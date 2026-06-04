package com.wipro.UserService.Service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.UserService.Entity.User;
import com.wipro.UserService.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo repository;

	
	
	     public User registerUser(User obj)
	     {
	    	 return repository.save(obj);
	    	 
	     }
	
	       public Optional<User> getUser(Long id)
	       {
	    	   return repository.findById(id);
	       }

		   public List<User> getAllUsers() {
			return repository.findAll();
		   }
	
}
