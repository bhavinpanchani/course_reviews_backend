package com.bhavinpanchani.course_reviews_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavinpanchani.course_reviews_backend.model.Course;
import com.bhavinpanchani.course_reviews_backend.repository.CourseRepo;

@Service
public class CourseService {

	@Autowired
	CourseRepo courseRepo;

	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}

	public List<Course> getAllCousesFilterByUniversityAndMajor(Long universityId, Long majorId) {
		return courseRepo.getAllCousesFilterByUniversityAndMajor(universityId, majorId);
	}

	public Course saveCourse(Course course, Long universityId, Long majorId) {
		Course newCourse = courseRepo.save(course);
		courseRepo.updateMajorCoursesTable(majorId, newCourse.getCourseId());
		return newCourse;
	}

	public void deleteCourse(Long id) {
		courseRepo.deleteCourseByIdInReferenceTable(id);
		courseRepo.deleteCourseById(id);
	}

}
