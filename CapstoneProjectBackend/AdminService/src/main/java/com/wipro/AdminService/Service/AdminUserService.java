package com.wipro.AdminService.Service;


import com.wipro.AdminService.Dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class AdminUserService {



    @Autowired
    private RestTemplate restTemplate;
// This method retrieves all users by making a GET request to the AuthService. It returns an array of UserDto objects representing the users in the system.
    public UserDto[] getAllUsers() {
        return restTemplate.getForObject(
                "http://AUTHSERVICE/auth/users",
                UserDto[].class
        );
    }

    public void deleteUser(Long id) {
        restTemplate.delete("http://AUTHSERVICE/auth/users/" + id);
    }
}