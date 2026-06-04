package com.wipro.InheritanceMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.InheritanceMapping.Entity.Student_Associate;

@Repository
public interface StudentPassportRepo extends JpaRepository<Student_Associate,Integer> {

}
