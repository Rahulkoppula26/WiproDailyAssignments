package com.wipro.SpringUnitTesting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.SpringUnitTesting.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
