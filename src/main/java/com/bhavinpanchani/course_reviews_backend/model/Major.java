package com.bhavinpanchani.course_reviews_backend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Major {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long majorId;
	String majorName;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	University university;

	@ManyToMany(cascade = CascadeType.ALL)
	Set<Course> courses;

	public Major() {
	}

	public Major(Long majorId, String majorName, University university, Set<Course> courses) {
		super();
		this.majorId = majorId;
		this.majorName = majorName;
		this.university = university;
		this.courses = courses;
	}

	public Long getMajorId() {
		return majorId;
	}

	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
