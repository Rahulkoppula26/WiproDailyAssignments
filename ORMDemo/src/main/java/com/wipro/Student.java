package com.wipro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity  // defining the class as a entity , to use this as a object declaration
public class Student {
	@Id
	int rollno;
	
	String name;
	
	@Column(name = "email", unique = true)
	String email;

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
