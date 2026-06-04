package com.wipro.InheritanceMapping.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;;

@Entity
public class StudentLearner {
	
	@Id
	int id;
	String name;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="st_id")
    List<Course> courselist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}


	
	
	
}