package com.wipro.AuthService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.AuthService.Dto.LoginRequest;
import com.wipro.AuthService.Dto.LoginResponse;
import com.wipro.AuthService.Dto.SignupRequest;
import com.wipro.AuthService.Entity.Role;
import com.wipro.AuthService.Entity.User;
import com.wipro.AuthService.Exception.DuplicateResourceException;
import com.wipro.AuthService.Exception.ResourceNotFoundException;
import com.wipro.AuthService.Repository.UserRepository;
import com.wipro.AuthService.Security.JwtUtil;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;
// This method handles user registration by accepting a SignupRequest object, checking for duplicate usernames, encoding the password, creating a new User entity, and saving it to the database. 
    public ResponseEntity<String> signupUser(SignupRequest requestObj) {

        if(userRepo.findByUsername(requestObj.getUsername()).isPresent()) {
            throw new DuplicateResourceException("Username already exists");
        }

        User user = new User();

        String simplePassword = requestObj.getPassword();
        String encodePassword = passwordEncoder.encode(simplePassword);

        user.setUsername(requestObj.getUsername());
        user.setPassword(encodePassword);
        user.setEmail(requestObj.getEmail());
        user.setPhone(requestObj.getPhone());
        user.setRole(Role.ROLE_USER);

        userRepo.save(user);
        return ResponseEntity.ok("User registered successfully") ;
    }

    public LoginResponse loginUser( LoginRequest requestObj){

        Optional<User> user =  Optional.of(userRepo.findByUsername(requestObj.getUsername()).orElseThrow(()-> new ResourceNotFoundException("User not found")));

        if(user.isPresent() &&  passwordEncoder.matches(requestObj.getPassword(),user.get().getPassword()) ){

            String token = jwtUtil.generateToken(user.get().getUsername(), user.get().getRole().name());

            return new LoginResponse(
        token,
        user.get().getRole().name(),
        user.get().getId(),
        user.get().getUsername()
);
        }
        throw new ResourceNotFoundException("Invalid username or password");
    }

    public ResponseEntity<List<User>> displayProfile() {
        return ResponseEntity.ok(userRepo.findAll());
    }
    

}
