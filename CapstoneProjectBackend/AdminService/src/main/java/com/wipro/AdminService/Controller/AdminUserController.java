package com.wipro.AdminService.Controller;

import com.wipro.AdminService.Dto.UserDto;
import com.wipro.AdminService.Service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/users")
public class AdminUserController {

    @Autowired
    private AdminUserService service;
// This method handles GET requests to retrieve all users. 
    @GetMapping
    public ResponseEntity<UserDto[]> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }
// This method handles GET requests to retrieve a user by their ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}