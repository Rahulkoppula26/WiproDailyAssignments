package com.wipro.InheritanceMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.InheritanceMapping.Entity.Student_Course_ManytoMany;

@Repository
public interface StudentCourseRepo_ManytoMany extends JpaRepository<Student_Course_ManytoMany, Long> {

	

}
