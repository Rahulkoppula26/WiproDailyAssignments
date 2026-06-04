package com.wipro.JWTdemo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.JWTdemo.Model.Employee;


//Step-2

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>{
	
	Optional<Employee> findByUsername(String username);
}
