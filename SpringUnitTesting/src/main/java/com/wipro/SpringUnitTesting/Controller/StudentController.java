package com.wipro.SpringUnitTesting.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.SpringUnitTesting.Entity.Student;
import com.wipro.SpringUnitTesting.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService service;
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
//	@GetMapping("/students/{id}")
//	public List<Student> getAllStudents() {
//		return service.getAllStudents();
//	}
	
	@GetMapping("/{id}")
	public Optional<Student> getStudentById(@PathVariable int id) {
		return service.getStudentById(id);
	}
	
}
