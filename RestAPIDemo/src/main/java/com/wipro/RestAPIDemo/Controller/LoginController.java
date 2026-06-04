package com.wipro.RestAPIDemo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.RestAPIDemo.Entity.User;
import com.wipro.RestAPIDemo.Service.UserService;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable int id ) {
		return service.getUser(id);	
	}
	
	@GetMapping
	public List<User> getUsers() {
		return service.getUsers();
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		service.deleteUser(id);
		return "user with id : "+ id+ " has been deleted";
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable int id,@RequestBody User user) {
		return service.updateUser(user);
	}
	
	@PatchMapping("/{id}")
	public Object updatePartOfUserData(@PathVariable int id, @RequestParam(required = false) String name, @RequestParam(required = false) String phone) {
		return service.updatePartOfUserData(id, name, phone);
	}
}
