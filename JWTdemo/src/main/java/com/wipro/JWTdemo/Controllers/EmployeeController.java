package com.wipro.JWTdemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.JWTdemo.Model.Employee;
import com.wipro.JWTdemo.Services.EmployeeService;

//step-4
@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	//step-8
	@PostMapping("/signup")
	public String addNewEmployee(@RequestBody Employee emp) {
		return service.signup(emp);
	}
	
	//step-13
	@PostMapping("/login")
	public String loginProcess(@RequestBody Employee emp) {
		return service.login(emp);
	}
	
	  @GetMapping("/profile")
	    public String fetchEmployee()
	    {
	    	return "fetched profile and its working with token only";
	    }

}
