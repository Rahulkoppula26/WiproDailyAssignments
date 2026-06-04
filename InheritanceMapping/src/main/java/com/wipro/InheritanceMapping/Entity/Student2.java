package com.wipro.InheritanceMapping.Entity;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student2 {
	
	@Id
	int id;
	String name;
	String email;
	
	@Embedded
	Address2 address2;  //composition or embedded mapping
	// has a relationship

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address2 getAddress() {
		return address2;
	}

	public void setAddress(Address2 address2) {
		this.address2 = address2;
	}
	
	
	
}

