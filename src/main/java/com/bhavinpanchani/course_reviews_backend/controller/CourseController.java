package com.bhavinpanchani.course_reviews_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhavinpanchani.course_reviews_backend.model.Course;
import com.bhavinpanchani.course_reviews_backend.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/uid/{universityId}/mid/{majorId}")
	public List<Course> getAllCousesFilterByUniversityAndMajor(@PathVariable Long universityId, @PathVariable Long majorId){
		return courseService.getAllCousesFilterByUniversityAndMajor(universityId, majorId);
	}
	
	@PostMapping("/uid/{universityId}/mid/{majorId}")
	public Course saveCourse(@RequestBody Course course, @PathVariable Long universityId, @PathVariable Long majorId){
		return courseService.saveCourse(course, universityId, majorId);
	}
	
	@DeleteMapping("/id/{id}")
	public void delteUniversity(@PathVariable Long id) {
		courseService.deleteCourse(id);
	}
}
