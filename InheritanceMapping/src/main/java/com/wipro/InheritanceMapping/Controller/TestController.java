package com.wipro.InheritanceMapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.InheritanceMapping.Entity.Boy;
import com.wipro.InheritanceMapping.Entity.Girl;
import com.wipro.InheritanceMapping.Entity.Student2;
import com.wipro.InheritanceMapping.Entity.User;
import com.wipro.InheritanceMapping.Service.UserService;



@RestController
@RequestMapping("/wipro")
public class TestController {

	@Autowired
	UserService service;
	
	
	@GetMapping("/welcome")
	  String getMessage()
	  {
		return "welcome to wipro app!";
	  }
	
	

	@GetMapping("/users")
	  List<User> getUsers()
	  {
	   return service.getAllUser();
	  }
	
	
	@PostMapping("/girl")
	  User signupUser( @RequestBody  Girl obj)
	  {
	   return    service.saveUserGirl(obj);
	  }
	@PostMapping("/boy")
	  User signupBoy( @RequestBody  Boy obj)
	  {
	   return    service.saveUserBoy(obj);
	  }
	
	
    
    
}