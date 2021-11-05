package com.bhavinpanchani.course_reviews_backend.healthcheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

	@GetMapping("/health-check")
	public String getHealthCheckStatus() {
		return "Service up and running";
	}
	
}
