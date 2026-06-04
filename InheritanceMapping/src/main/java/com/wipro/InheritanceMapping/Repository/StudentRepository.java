package com.wipro.InheritanceMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.InheritanceMapping.Entity.Student2;

@Repository
public interface StudentRepository extends JpaRepository<Student2, Integer> {
}
