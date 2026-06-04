package com.wipro.InheritanceMapping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.InheritanceMapping.Entity.Student2;
import com.wipro.InheritanceMapping.Entity.StudentLearner;
import com.wipro.InheritanceMapping.Entity.Student_Associate;
import com.wipro.InheritanceMapping.Repository.StudentCourseRepo;
import com.wipro.InheritanceMapping.Repository.StudentPassportRepo;
import com.wipro.InheritanceMapping.Repository.StudentRepository;

@Service
public class StudentSevice {
	@Autowired
    private StudentRepository studentRepository;
	
	@Autowired
	private StudentPassportRepo studentPassportRepo;
	
	@Autowired
	private StudentCourseRepo studentCourseRepo;
	
	
	
    // Method to save a new student with their embedded address
    public Student2 saveStudent(Student2 student2) {
        return studentRepository.save(student2);
    }

    // Method to retrieve all students
    public List<Student2> getAllStudents() {
        return studentRepository.findAll();
    }

	public Student_Associate saveStudentPassport(Student_Associate student) {
		return studentPassportRepo.save(student);
	}

	public List<Student_Associate> getAllStudentsPassport() {
		return studentPassportRepo.findAll();
	}
	public StudentLearner addNewStudentCourseData(StudentLearner studentLearner) {
		return studentCourseRepo.save(studentLearner);
	}
	
	public List<StudentLearner> getAllCourseStudents() {
		return studentCourseRepo.findAll();
	}
	
	
}
