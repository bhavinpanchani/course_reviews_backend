package com.bhavinpanchani.course_reviews_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bhavinpanchani.course_reviews_backend.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{

	@Query(value = "SELECT c.course_id, c.course_name, c.course_description FROM course c JOIN major_courses mc ON mc.courses_course_id = c.course_id JOIN major m ON mc.majors_major_id = m.major_id JOIN university u ON u.university_id = m.university_id WHERE u.university_id = :universityId AND m.major_id = :majorId",
			nativeQuery = true)
	List<Course> getAllCousesFilterByUniversityAndMajor(Long universityId, Long majorId);
	
	@Modifying
	@Transactional
	@Query(value = "Insert into major_courses values (:majorId,:courseId)",
			nativeQuery = true )
	Integer updateMajorCoursesTable(Long majorId, Long courseId);

	@Modifying
	@Transactional
	@Query(value = "Delete from major_courses where courses_course_id = :id",
			nativeQuery = true )
	void deleteCourseByIdInReferenceTable(Long id);

	@Modifying
	@Transactional
	@Query(value = "Delete from course where course_id = :id",
			nativeQuery = true )
	void deleteCourseById(Long id);

}
