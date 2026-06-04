package com.wipro.InheritanceMapping.Entity;

import jakarta.persistence.*;

@Entity
public class Student_Associate {

	@Id
	int id;
	String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="passport_id")
	Passport_Associate passport;
	
	

	public Passport_Associate  getPassport() {
		return passport;
	}

	public void setPassport(Passport_Associate passport) {
		this.passport = passport;
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

}
