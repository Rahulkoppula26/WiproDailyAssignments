package com.wipro.RestAPIDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.RestAPIDemo.Entity.User;
import com.wipro.RestAPIDemo.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public List<User> getUsers() {
		return repo.findAll();
	}

	public User getUser(int id) {
		return repo.findById(id).orElse(new User());
	}
	
	public User addUser(User obj) {
		return repo.save(obj);
	}
	
	public void deleteUser(int id) {
		 repo.deleteById(id);
	}
	
	public User updateUser(User user) {
		return repo.save(user);
	}

	public User updatePartOfUserData(int id, @RequestParam(required = false) String name, @RequestParam(required = false) String phone) {
		User user =  repo.findById(id).orElseThrow();
		return repo.save(user);
		
	}

	
	
}
