package com.wipro.AdminService.Dto;

import lombok.Data;

@Data
public class UserDto {
    Long id;
    String username;
    String password;
    String email;
    String phone;

}
