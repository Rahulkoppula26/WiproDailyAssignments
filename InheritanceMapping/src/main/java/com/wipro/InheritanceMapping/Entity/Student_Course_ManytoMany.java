package com.wipro.InheritanceMapping.Entity;



import java.util.List;

import jakarta.persistence.*;

@Entity
public class Student_Course_ManytoMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany

    @JoinTable(
        name = "student_course",

        joinColumns = @JoinColumn(name = "student_id"),  // primary key of current entity

        inverseJoinColumns = @JoinColumn(name = "course_id") // foriegnkey or primary key from another entity
    )

    private List<Course_Manytomany> courses;

    public Student_Course_ManytoMany() {
    }

    public Student_Course_ManytoMany(String name, List<Course_Manytomany> courses) {
        this.name = name;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course_Manytomany> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(List<Course_Manytomany> newlist) {
        this.courses = newlist;
    }
}