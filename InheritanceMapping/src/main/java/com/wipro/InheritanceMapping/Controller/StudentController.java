package com.wipro.InheritanceMapping.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.InheritanceMapping.Entity.Student2;
import com.wipro.InheritanceMapping.Entity.StudentLearner;
import com.wipro.InheritanceMapping.Entity.Student_Associate;
import com.wipro.InheritanceMapping.Service.StudentSevice;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentSevice studentSevice;

    // Route: POST http://localhost:8080/api/students/register
    @PostMapping("/register")
    public Student2 registerStudent(@RequestBody Student2 student2) {
//        return studentService.saveStudent(student2);
    	return studentSevice.saveStudent(student2);
    }

    // Route: GET http://localhost:8080/api/students/all
    @GetMapping("/all")
    public List<Student2> getAllStudents() {
    	return studentSevice.getAllStudents();
    }
    
    @PostMapping("/stuPassport")
    public Student_Associate studentPassport(@RequestBody Student_Associate student) {
    	return studentSevice.saveStudentPassport(student);
    }

    
    @GetMapping("/allStudentPassport")
    public List<Student_Associate> getAllStudentsPassport() {
    	return studentSevice.getAllStudentsPassport();
    }
    
    @PostMapping("/stuCourse")
    public StudentLearner addStudentCourseLearnerData(@RequestBody StudentLearner student) {
    	return studentSevice.addNewStudentCourseData(student);
    }

    // Route: GET http://localhost:8080/api/students/all
    @GetMapping("/allStudentCourse")
    public List<StudentLearner> getAllStudentsCourseData() {
    	return studentSevice.getAllCourseStudents();
    }
    
    
}