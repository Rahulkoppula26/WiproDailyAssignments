package com.wipro.DIDemo;

public class Student {
    private int id;
    private String name;
    private Address address;

    // Constructor Injection
    public Student(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Default Constructor
    public Student() {
    }


    // Field display
    public void show() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        address.show();
    }
}