package com.bhavinpanchani.course_reviews_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavinpanchani.course_reviews_backend.model.Major;
import com.bhavinpanchani.course_reviews_backend.repository.MajorRepo;

@Service
public class MajorService {

	@Autowired
	private MajorRepo majorRepo;

	public List<Major> findAllMajor() {
		return majorRepo.findAll();
	}

	public Major saveMajor(Major major, Long universityId) {
		Major newMajor= majorRepo.save(major);
		majorRepo.updateMajor(universityId, newMajor.getMajorId());
		return newMajor;
	}

	public Optional<Major> findMajorById(Long id) {
		return majorRepo.findById(id);
	}

	public void deleteUniversity(Long id) {
		majorRepo.deleteById(id);
	}
	
}
