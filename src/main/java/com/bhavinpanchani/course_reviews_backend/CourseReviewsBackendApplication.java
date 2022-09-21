package com.bhavinpanchani.course_reviews_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CourseReviewsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseReviewsBackendApplication.class, args);
		
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/university/**").allowedOrigins("http://127.0.0.1:3000", "http://localhost:3000", "https://bhavinpanchani.github.io");
			}
		};
	}
}