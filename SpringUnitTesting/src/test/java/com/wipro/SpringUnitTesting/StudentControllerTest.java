package com.wipro.SpringUnitTesting;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.wipro.SpringUnitTesting.Entity.Student;
import com.wipro.SpringUnitTesting.Repository.StudentRepository;
import com.wipro.SpringUnitTesting.Service.StudentService;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

	  @Mock
	  private StudentRepository repo;
	  
	  @InjectMocks
	  private StudentService service;

	    @Test
	    public void getStudentByIdTest(){
	    	   Student s1 = new Student();
	           s1.setId(1);
	           s1.setName("Rahul");
	           
	           //when( something happens ).thenReturn( something );
	           when(repo.findById(1)).thenReturn(Optional.of(s1));
	           
	           //getting the getStudentById from the service method by passing id
	           Optional<Student> student = service.getStudentById(1);
	           
	           //check it is null or not
	           assertNotNull(student);
	           
	           //checking id is equals to the our test id
	           assertEquals(1, student.get().getId());
	           
	         //checking name from student object is equals to the our test name
	           assertEquals("Rahul", student.get().getName());
	    	
	    }

}