package com.wipro.AuthService.Dto;

import lombok.Data;

@Data
public class SignupRequest {

    private String username;
    private String password;
    private String email;
    private String phone;

}


