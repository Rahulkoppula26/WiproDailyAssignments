package com.wipro.InheritanceMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.InheritanceMapping.Entity.Course_Manytomany;

@Repository
public interface CourseRepo_Manytomany extends JpaRepository<Course_Manytomany, Integer> {

}
