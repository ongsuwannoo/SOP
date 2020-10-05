package com.ong.springswagger.models;

import javax.persistence.*;

@Entity
public class Event {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private String date;
	private String owner;
	
	public Event() {
		super();
	}

	public Event(Long id, String name, String description, String date, String owner) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.owner = owner;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
		
}