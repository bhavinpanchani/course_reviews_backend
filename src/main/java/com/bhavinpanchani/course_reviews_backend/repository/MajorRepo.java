package com.bhavinpanchani.course_reviews_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bhavinpanchani.course_reviews_backend.model.Major;

@Repository
public interface MajorRepo extends JpaRepository<Major, Long>{

	@Modifying
	@Transactional
	@Query("UPDATE Major SET university_id = :universityId WHERE major_id = :majorId")
	Integer updateMajor(Long universityId, Long majorId);

}
