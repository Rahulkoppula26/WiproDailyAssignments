package com.NativeSQL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentN {
	
	@Id
	private int rollno;
	
	private String name;
	private String department;
	
	
	
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
