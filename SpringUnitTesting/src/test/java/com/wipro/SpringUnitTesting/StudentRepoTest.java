package com.wipro.SpringUnitTesting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.wipro.SpringUnitTesting.Entity.Student;
import com.wipro.SpringUnitTesting.Repository.StudentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)// Replace existing DataSource
public class StudentRepoTest {

	@Autowired
	StudentRepository repo;

	@Test
	public void saveStudentTest() {

		Student s1 = new Student();
		s1.setName("Rahul");
		//saving the student object 
		Student savedStu = repo.save(s1);
		//cheching the data is not null : if null then test fails
		assertNotNull(s1.getId());

	}

}