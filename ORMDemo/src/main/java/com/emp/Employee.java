package com.emp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//Hibernate 
//
//Employee Fields
//empId
//empName
//empDepartment
//empSalary
//empEmail

//Tasks
//Insert Employee
//Search Employee by ID
//Update Salary
//Delete Employee
//Display All Employees

@Entity
public class Employee {
	@Id
	int empID;
	
	String empName;
	String empDepartment;
	int empSalary;
	
	@Column(name = "email" , unique = true)
	String empEmail;
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	
	
}
