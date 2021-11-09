package com.bhavinpanchani.course_reviews_backend.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@GetMapping("/")
	public String homePage() {
		return "Welcome to StudyON \nFind all details for Universities, Majors, Courses, Professors";
	}
	
}
