package com.wipro.InheritanceMapping.Entity;

import jakarta.persistence.Embeddable;

@Embeddable   // embedded or composition mapping
public class Address2 {
  String hno;
  String city;
public String getHno() {
	return hno;
}
public void setHno(String hno) {
	this.hno = hno;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
  
}
