package com.ong.springswagger.models;

import javax.persistence.*;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Long Assess_the_location;
	private Long Evaluate_teachers;
	
	public Student() {
		super();
	}

	public Student(Long id, String name, Long Assess_the_location) {
		super();
		this.id = id;
		this.name = name;
		this.Assess_the_location = Assess_the_location;
//		this.Evaluate_teachers = Evaluate_teachers;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAssess_the_location() {
		return Assess_the_location;
	}
	public void setAssess_the_location(Long Assess_the_location) {
		this.Assess_the_location = Assess_the_location;
	}
//	public Long getEvaluate_teachers() {
//		return Evaluate_teachers;
//	}
//	public void setEvaluate_teachers(Long Evaluate_teachers) {
//		this.Evaluate_teachers = Evaluate_teachers;
//	}
		
}