package com.wipro.UserDataCreationJWT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.UserDataCreationJWT.Entity.UserEmployeeData;
import com.wipro.UserDataCreationJWT.Services.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService service;
	
	
	@GetMapping("/login/{id}")
	public ResponseEntity<UserEmployeeData> getUserData(@PathVariable int id){
		return service.getUserDataById(id);
	}
	
	@PostMapping("/register")
	public void addNewUserData(@RequestBody UserEmployeeData userEmployeeData) {
		service.addUserData(userEmployeeData);
	}
	
}
