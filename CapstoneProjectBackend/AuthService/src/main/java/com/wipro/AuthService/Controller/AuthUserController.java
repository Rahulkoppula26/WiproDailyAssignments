package com.wipro.AuthService.Controller;

import com.wipro.AuthService.Entity.User;
import com.wipro.AuthService.Service.AuthUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/users")
public class AuthUserController {

    @Autowired
    private AuthUserService service;
// This method handles GET requests to retrieve all users.
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
// This method handles GET requests to retrieve a user by their ID. It returns the user if found, or null if not found.
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}