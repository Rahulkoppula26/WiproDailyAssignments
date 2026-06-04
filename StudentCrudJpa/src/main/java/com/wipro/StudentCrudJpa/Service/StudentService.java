package com.wipro.StudentCrudJpa.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.StudentCrudJpa.Entity.Student;
import com.wipro.StudentCrudJpa.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;
	
	public void addStudent(Student student) {
		 repository.save(student);
	}
	
	public Optional<Student> getStudent(int rollno) {
		return repository.findById(rollno);
	}
	
	public List<Student> getAllStudents(){
		return repository.findAll();
	}
	public void deleteStudentByName(@RequestParam String name) {
		repository.deleteByName(name);
	}
	
	public String updateStudent(int rollno, String newName) {
	Optional<Student> studentOptional = repository.findById(rollno);
	  if(studentOptional.isPresent()) {
		  Student student = studentOptional.get();
		  student.setName(newName);
		  repository.save(student);
		  return "Student data is updated";
	  }else {
		  return "Student not found";
	  }
	}
	
	public String updateEntireStudentData(int rollno,Student obj) {
		
		Optional<Student> stuOptional = repository.findById(rollno);
		if(stuOptional.isPresent()) {
			Student student = stuOptional.get();
			student.setRollno(rollno);
			student.setName(obj.getName());
			student.setEmail(obj.getEmail());
			repository.save(student);
			return "Student data is updated";
		}else {
			return "not found";
		}
		
	}
}












