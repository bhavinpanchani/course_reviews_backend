package com.bhavinpanchani.course_reviews_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhavinpanchani.course_reviews_backend.model.Major;
import com.bhavinpanchani.course_reviews_backend.service.MajorService;

@RestController
@RequestMapping("/major")
public class MajorController {

	@Autowired
	MajorService majorService;
	
	@GetMapping("/")
	public List<Major> getAllMajor(){
		return majorService.findAllMajor();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Major> getMajorById(@PathVariable Long id){
		return majorService.findMajorById(id);
	}
	
	@PostMapping("/uid/{universityId}")
	public Major saveMajor(@RequestBody Major major, @PathVariable Long universityId){
		
		return majorService.saveMajor(major, universityId);
	}
	
	@DeleteMapping("/id/{id}")
	public void delteUniversity(@PathVariable Long id) {
		majorService.deleteUniversity(id);
	}
	
}
