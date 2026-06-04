package com.wipro.SpringUnitTesting.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.SpringUnitTesting.Entity.Student;
import com.wipro.SpringUnitTesting.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;
	
	public Student saveStudent(Student student) {
		return repository.save(student);
	}
	
//	public List<Student> getAllStudents(){
//		return repository.findAll();
//	}

	public Optional<Student> getStudentById(int id) {
		return repository.findById(id);
	}
	
}
