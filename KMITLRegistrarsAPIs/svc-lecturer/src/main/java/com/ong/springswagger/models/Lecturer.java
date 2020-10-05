package com.ong.springswagger.models;

import javax.persistence.*;

@Entity
public class Lecturer {
	@Id
	@GeneratedValue
	private Long id;
	private String lecturerName;
	private String courseId;
	private Integer studentNumber;
	
	public Integer getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}

	public Lecturer() {
		super();
	}

	public Lecturer(Long id, String lecturerName, String courseId, Integer studentNumber) {
		super();
		this.id = id;
		this.lecturerName = lecturerName;
		this.courseId = courseId;
		this.studentNumber = studentNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return lecturerName;
	}
	public void setName(String lecturerName) {
		this.lecturerName = lecturerName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
		
}