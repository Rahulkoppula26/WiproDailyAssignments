package com.wipro.AuthService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.AuthService.Entity.User;
import com.wipro.AuthService.Exception.ResourceNotFoundException;
import com.wipro.AuthService.Repository.UserRepository;

@Service
public class AuthUserService {
    @Autowired
    UserRepository userRepo;
    
public List<User> getAllUsers() {
    return userRepo.findAll();
}

public void deleteUser(Long id) {
    if (!userRepo.existsById(id)) {
        throw new ResourceNotFoundException("User not found with id: " + id);
    }
    userRepo.deleteById(id);
}
}
