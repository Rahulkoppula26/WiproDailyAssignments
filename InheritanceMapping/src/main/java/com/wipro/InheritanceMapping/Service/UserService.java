package com.wipro.InheritanceMapping.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.InheritanceMapping.Entity.Boy;
import com.wipro.InheritanceMapping.Entity.Girl;
import com.wipro.InheritanceMapping.Entity.User;
import com.wipro.InheritanceMapping.Repository.UserRepository;



@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public User saveUserGirl(Girl obj) {
	
		return repository.save(obj);
	}
	public User saveUserBoy(Boy obj) {
		
		return repository.save(obj);
	}

	public List<User> getAllUser() {
		return repository.findAll();
	}
	

}
