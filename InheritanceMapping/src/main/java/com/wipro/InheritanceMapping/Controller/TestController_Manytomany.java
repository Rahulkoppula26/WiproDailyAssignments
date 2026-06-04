package com.wipro.InheritanceMapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.InheritanceMapping.Entity.Student_Course_ManytoMany;
import com.wipro.InheritanceMapping.Service.Student_Course_manytomany;
import com.wipro.InheritanceMapping.Service.UserService;

@RestController
@RequestMapping("/wipro")
public class TestController_Manytomany {

	@Autowired
	UserService service;
	
	@Autowired
	Student_Course_manytomany serv;
	
	@PostMapping("/student")
	 public Student_Course_ManytoMany  saveStudent(@RequestBody Student_Course_ManytoMany obj)
	  {
		return serv.saveUser(obj);
		
	  }}