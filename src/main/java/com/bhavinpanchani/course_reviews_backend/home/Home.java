package com.bhavinpanchani.course_reviews_backend.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@GetMapping("/")
	public String homePage() {
		return "Welcome to StudyON - Find all details for Universities, Majors, Courses, Professors. Created new Branch named Test-Branch-Created-Github in Github";
	}
	
}
