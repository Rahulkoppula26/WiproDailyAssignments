package com.wipro.JWTdemo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.wipro.JWTdemo.JwtUtil;
import com.wipro.JWTdemo.Model.Employee;
import com.wipro.JWTdemo.Repository.EmployeeRepo;
//Step-3

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo repo;
	
	//step-5
	@Autowired
	PasswordEncoder passwordEncoder;
	
	//step-11
	@Autowired
	JwtUtil utility;
	
	//step-7
	public String signup(Employee emp) {
		String simplePassword = emp.getPassword();
		String encodedPassword = passwordEncoder.encode(simplePassword);
		emp.setPassword(encodedPassword);
		repo.save(emp);
		return "Employee signup success";
	}
	
	//step-9
	public String login(Employee emp) {
		 Optional<Employee> dbUser = repo.findByUsername(emp.getUsername());
	        if (dbUser.isPresent() && passwordEncoder.matches(emp.getPassword(), dbUser.get().getPassword())) {
	        	//step-12      
	        	return utility.generateToken(emp.getUsername());
	        }else {
	        	
	        	return "Invalid Username or Password";
	        }
	}
	
	
		
}
