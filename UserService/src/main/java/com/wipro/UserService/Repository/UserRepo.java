package com.wipro.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.UserService.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
