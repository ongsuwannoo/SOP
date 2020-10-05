package com.ong.springswagger.models;

import javax.persistence.*;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private Long id;
	private String couseid;
	private String coursename;
	private int credit;
	private String section;
	private String instructorname;
	public String getCouseid() {
		return couseid;
	}

	public void setCouseid(String couseid) {
		this.couseid = couseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getInstructorname() {
		return instructorname;
	}

	public void setInstructorname(String instructorname) {
		this.instructorname = instructorname;
	}
		
	public Course() {
		super();
	}


	public Course(Long id, String couseid, String coursename, int credit, String section, String instructorname) {
		super();
		this.id = id;
		this.couseid = couseid;
		this.coursename = coursename;
		this.credit = credit;
		this.section = section;
		this.instructorname = instructorname;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		
}