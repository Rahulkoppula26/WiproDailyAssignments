package com.wipro.InheritanceMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.InheritanceMapping.Entity.StudentLearner;

@Repository
public interface StudentCourseRepo extends JpaRepository<StudentLearner, Integer> {

}
