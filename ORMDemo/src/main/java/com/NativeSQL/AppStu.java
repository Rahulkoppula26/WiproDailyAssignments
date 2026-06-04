package com.NativeSQL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppStu {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(StuConfig.class);
		StudentNDao dao = context.getBean(StudentNDao.class);
		
		dao.saveStudent();
		dao.getStudent(4);
		dao.getAllStudents();
		dao.updateStudent(1, "Developer");
		dao.deleteStudent(6);
	}
}
