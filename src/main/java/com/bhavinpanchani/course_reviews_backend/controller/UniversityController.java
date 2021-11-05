package com.bhavinpanchani.course_reviews_backend.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhavinpanchani.course_reviews_backend.model.University;
import com.bhavinpanchani.course_reviews_backend.service.UniversityService;

@RestController()
@RequestMapping("/university")
public class UniversityController {

	Logger log = LoggerFactory.getLogger(UniversityController.class);

	@Autowired
	private UniversityService universityService;

	@GetMapping("/")
	public List<University> getAllUniversity(University university) {
		log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
		return universityService.findAllUniversity();
	}

	@GetMapping("/id/{id}")
	public Optional<University> getUniversityById(@PathVariable Long id) {
		return universityService.findById(id);
	}

	@GetMapping("/name/{universityName}")
	public Optional<University> getUniversityByUniversityName(@PathVariable String universityName) {
		return universityService.findByUniversityName(universityName);
	}

	@PostMapping("/")
	public University saveUniversity(@RequestBody University university) {
		System.out.println(university.toString());
//		University uniRef = new University();
		return universityService.saveUniversity(university);
	}

	@PutMapping("/id/{id}")
	public University updateUniversity(@RequestBody University university, @PathVariable Long id) {
		university.setUniversityId(id);
		return universityService.saveUniversity(university);
	}

	@DeleteMapping("/id/{id}")
	public void delteUniversity(@PathVariable Long id) {
		universityService.deleteUniversity(id);
	}

}
