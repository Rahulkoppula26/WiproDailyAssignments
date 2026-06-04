package com.wipro.DIDemo;



//setter injection
public class Address {
	private String city;


	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void show() {
		System.out.println("City: " + city);
	}
}