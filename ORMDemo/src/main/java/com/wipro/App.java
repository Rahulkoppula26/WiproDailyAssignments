package com.wipro;


import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    	StudentDao studentDao = context.getBean(StudentDao.class);

		System.out.println("Enter the student details");
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("Enter rollno , name and email");
		
		int rollno = s.nextInt();
		String name = s.next();
		String email = s.next();
	
		
		Student obj1=new Student();
		obj1.setRollno(rollno);
		obj1.setName(name);
		obj1.setEmail(email);
		
		      studentDao.saveStudent(obj1);
		    Student obj2=studentDao.getStudent(rollno);
		  System.out.println(obj2.getName()+" -- "+obj2.getEmail());
		  
		  
		  studentDao.getAll();
		 
		  List<Student> obj3 = studentDao.getAll();
		
		  obj3.forEach(student ->
		    System.out.println(student.getName() + " -- " + student.getEmail())
		);
		  
	}
}
