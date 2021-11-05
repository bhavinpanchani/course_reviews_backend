package com.bhavinpanchani.course_reviews_backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long universityId;
	String universityName;
	String universityAddress;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;


	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "university_id", referencedColumnName = "universityId")
	List<Major> majors = new ArrayList<>();

	public University() {
	}

	public University(Long universityId, String universityName, String universityAddress, Date createdAt,
			Date updatedAt, List<Major> majors) {
		super();
		this.universityId = universityId;
		this.universityName = universityName;
		this.universityAddress = universityAddress;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.majors = majors;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getUniversityAddress() {
		return universityAddress;
	}

	public void setUniversityAddress(String universityAddress) {
		this.universityAddress = universityAddress;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	@Override
	public String toString() {
		return "University [id=" + universityId + ", universityName=" + universityName + ", universityAddress="
				+ universityAddress + ", majors=" + majors + "]";
	}

}
