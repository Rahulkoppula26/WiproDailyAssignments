package com.wipro.InheritanceMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.InheritanceMapping.Entity.User;


@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{

}
