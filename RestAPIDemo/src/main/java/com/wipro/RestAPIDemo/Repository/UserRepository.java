package com.wipro.RestAPIDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.RestAPIDemo.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}