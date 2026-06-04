package com.NativeSQL;

public interface StudentNDao {
	
	void saveStudent();
	void getStudent(int rollno);
	void getAllStudents();
	void updateStudent(int rollno ,String department);
	void deleteStudent(int rollno);
	
}
