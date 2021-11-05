package com.bhavinpanchani.course_reviews_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavinpanchani.course_reviews_backend.model.University;
import com.bhavinpanchani.course_reviews_backend.repository.UniversityRepo;

@Service
public class UniversityService {

	@Autowired
	private UniversityRepo universityRepo;

	public University saveUniversity(University university) {
		return universityRepo.save(university);
	}

	public List<University> findAllUniversity() {
		return universityRepo.findAll();
	}

	public Optional<University> findById(Long id) {
		return universityRepo.findById(id);
	}

	public Optional<University> findByUniversityName(String universityName) {
		return universityRepo.findByUniversityName(universityName);
	}

//	public University updateUniversity(Long id, University university) {
//		universityRepo.deleteById(id);
//		return universityRepo.save(university);
//	}

	public void deleteUniversity(Long id) {
		universityRepo.deleteById(id);
	}
	
	

	
}
