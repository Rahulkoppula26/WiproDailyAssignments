package com.wipro.JDBCMethod.Student;

public class Student {
	  private int id;
	  private String name;
	  private long contactNumber;
	  private String address;
	 
	  public Student() {
	   super();
	  }

	  public Student(int id, String name, long contactNumber, String address) {
	   super();
	   this.id = id;
	   this.name = name;
	   this.contactNumber = contactNumber;
	   this.address = address;
	  }

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
	  public long getContactNumber() {
	   return contactNumber;
	  }
	  public void setContactNumber(long contactNumber) {
	   this.contactNumber = contactNumber;
	  }
	  public String getAddress() {
	   return address;
	  }
	  public void setAddress(String address) {
	   this.address = address;
	  }
	  @Override
	  public String toString() {
	   return "Student ID : " + id + ", Student name : " + name + ", Contact number : " + contactNumber + ", Address : " + address;
	  }
	}
