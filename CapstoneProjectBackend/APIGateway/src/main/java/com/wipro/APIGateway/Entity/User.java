package com.wipro.APIGateway.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "UserJwt")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String password;
}

