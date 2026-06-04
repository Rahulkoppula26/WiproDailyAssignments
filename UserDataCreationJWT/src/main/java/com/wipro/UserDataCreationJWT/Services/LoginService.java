package com.wipro.UserDataCreationJWT.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.UserDataCreationJWT.Entity.UserEmployeeData;
import com.wipro.UserDataCreationJWT.Repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository repository;
	
	public ResponseEntity<UserEmployeeData> getUserDataById(int id) {
		UserEmployeeData userEmployeeData = repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
		return ResponseEntity.ok(userEmployeeData);
	}
	
	public void addUserData(UserEmployeeData userEmployeeData) {
		repository.save(userEmployeeData);
	}
	
}
