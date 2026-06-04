package com.wipro.AuthService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.AuthService.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

     Optional<User> findByUsername(String username);
     Optional<User> findByEmail(String email);
     Optional<User> findByPhone(String phone);
}
