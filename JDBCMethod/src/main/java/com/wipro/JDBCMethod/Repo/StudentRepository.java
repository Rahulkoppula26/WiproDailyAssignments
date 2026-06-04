package com.wipro.JDBCMethod.Repo;

import java.util.List;
import com.wipro.JDBCMethod.Student.*;

public interface StudentRepository  {
	
	int addStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(int id);

	int updateStudent(Student student);

	int deleteStudentById(int id);
}
