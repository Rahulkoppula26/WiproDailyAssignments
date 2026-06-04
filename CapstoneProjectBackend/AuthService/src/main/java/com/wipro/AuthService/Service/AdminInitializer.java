package com.wipro.AuthService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wipro.AuthService.Entity.Role;
import com.wipro.AuthService.Entity.User;
import com.wipro.AuthService.Repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class AdminInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;
// This method is annotated with @PostConstruct, which means it will be executed after the bean is initialized. It checks if a user with the username "rahul" already exists in the database. If not, it creates a new User object with the username "rahul", encodes the password "rahul123", assigns the role of ROLE_ADMIN, and saves the user to the database. This ensures that there is an admin user available when the application starts.
    @PostConstruct
    public void initAdmin() {

        if (userRepository.findByUsername("rahul").isEmpty()) {

            User admin = new User();

            admin.setUsername("rahul");
            admin.setPassword(encoder.encode("rahul123"));
            admin.setRole(Role.ROLE_ADMIN);

            userRepository.save(admin);
        }
    }
}