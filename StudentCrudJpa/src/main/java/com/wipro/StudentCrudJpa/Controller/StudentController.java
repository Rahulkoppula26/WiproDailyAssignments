package com.wipro.StudentCrudJpa.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.StudentCrudJpa.Entity.Student;
import com.wipro.StudentCrudJpa.Service.StudentService;

import jakarta.transaction.Transactional;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/add")
	public String addStudent(@RequestBody Student student) {
		service.addStudent(student);
		return "Student data added to the database";
	}
	
	@GetMapping("/student/{rollno}")
	public String getStudent(@PathVariable int rollno) {
		Optional<Student> studentOptional= service.getStudent(rollno);
		if(studentOptional.isPresent()) {
			return "User Found : "+ studentOptional.get();
		}
		else {
			return "student not found";
		}
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}
	
	@Transactional
	@DeleteMapping("/delete/{name}")
	public String deleteStudentData(@PathVariable String name) {
		service.deleteStudentByName(name);
		return "Student data with name : "+ name + " is deleted";
	}
	
	@PatchMapping("/update/{rollno}")
	public String  updateStudent(@PathVariable int rollno,@RequestParam String name) {
		service.updateStudent(rollno, name);
		return "Student data with rollno : "+ rollno + " is updated";
	}
	@PutMapping("/updateData/{rollno}")
	public String updateEntireStudentData(@PathVariable int rollno,@RequestBody Student object ) {
		service.updateEntireStudentData(rollno,object );
		return "Student data is updated" + object;
	}
}





