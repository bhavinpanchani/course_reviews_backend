package com.bhavinpanchani.course_reviews_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhavinpanchani.course_reviews_backend.model.University;

@Repository
public interface UniversityRepo extends JpaRepository<University, Long>{

	Optional<University> findByUniversityName(String universityName);

}
