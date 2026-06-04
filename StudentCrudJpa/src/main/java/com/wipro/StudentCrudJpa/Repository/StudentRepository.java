package com.wipro.StudentCrudJpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.StudentCrudJpa.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Object deleteByName(String name);
	

}
