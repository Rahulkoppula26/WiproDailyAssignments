package com.wipro.InheritanceMapping.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.InheritanceMapping.Entity.Course_Manytomany;
import com.wipro.InheritanceMapping.Entity.Student_Course_ManytoMany;
import com.wipro.InheritanceMapping.Repository.CourseRepo_Manytomany;
import com.wipro.InheritanceMapping.Repository.StudentCourseRepo_ManytoMany;

@Service
public class Student_Course_manytomany {
	
	@Autowired
	StudentCourseRepo_ManytoMany repository;
	
	@Autowired
	CourseRepo_Manytomany repo;

	
	public Student_Course_ManytoMany saveUser(Student_Course_ManytoMany obj) {
		        List<Course_Manytomany> newlist=new ArrayList<>()  ;
		        for(Course_Manytomany cc: repo.findAll())
		        {            
		 
		        	if(cc.getName().equalsIgnoreCase("Java") || cc.getName().equalsIgnoreCase("python") )
		                 newlist.add(cc);
		        }
		        
		        obj.setCourses(newlist);
		return repository.save(obj);
	}

	public List<Student_Course_ManytoMany> getAllUser() {
		return repository.findAll();
	}
	
}