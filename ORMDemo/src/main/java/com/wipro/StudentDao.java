package com.wipro;

import java.util.List;

public interface StudentDao {
	

    void saveStudent(Student student);
    
    Student getStudent(int rollno);
    
    List<Student> getAll();
    
   
}
