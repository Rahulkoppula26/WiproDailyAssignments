package com.wipro.AuthService.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.AuthService.Dto.LoginRequest;
import com.wipro.AuthService.Dto.LoginResponse;
import com.wipro.AuthService.Dto.SignupRequest;
import com.wipro.AuthService.Entity.User;
import com.wipro.AuthService.Exception.ResourceNotFoundException;
import com.wipro.AuthService.Repository.UserRepository;
import com.wipro.AuthService.Service.AuthService;


@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    AuthService service;

    @Autowired
    UserRepository userRepo;
// This method handles POST requests to the /auth/signup endpoint.
    @PostMapping("/signup")
    public ResponseEntity<String> signupUser(@RequestBody SignupRequest user){
        return service.signupUser(user);
    }
// This method handles POST requests to the /auth/login endpoint. 
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest user){
        System.out.println("sucessfully hit the login api");
        return service.loginUser(user);
    }
// This method handles GET requests to the /auth/profile endpoint. 
   @GetMapping("/profile")
public ResponseEntity<User> getProfile(Authentication authentication) {

    String username = authentication.getName();

    User user = userRepo.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    return ResponseEntity.ok(user);
}
}
