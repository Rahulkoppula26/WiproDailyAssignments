package com.wipro;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class Studentimpl  implements StudentDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void saveStudent(Student obj) {
		Session sobj = sessionFactory.getCurrentSession();
		  sobj.save(obj);
	}

	public Student getStudent(int rollno) {
		Session sobj = sessionFactory.getCurrentSession();
		return (Student) sobj.get(Student.class, rollno);
	}

	public List<Student> getAll() {
		Session sobj = sessionFactory.getCurrentSession();
		 return   sobj.createQuery("from Student",Student.class).getResultList();
	}
	
	public void deleteStudent(int rollno) {
		 Session sobj = sessionFactory.getCurrentSession();
		     Student ss=   getStudent(rollno);
		    sobj.remove(ss);
		    System.out.println("Student is deleted!");   
		    
	}

}


