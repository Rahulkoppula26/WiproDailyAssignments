package com.NativeSQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentNDaoImpl implements StudentNDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveStudent() {
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	
	StudentN s1 = new StudentN();
	s1.setRollno(10);
	s1.setName("rahul");
	s1.setDepartment("Engineering");
	
	session.save(s1);
	tx.commit();
	}

	@Override
	public void getStudent(int rollno) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "select * from Students where rollno = :rollno";
		NativeQuery<StudentN> query = session.createNativeQuery(sql, StudentN.class);
		query.setParameter(rollno, query);
		List<StudentN> list = query.list();
		
		for (StudentN stu : list) {
            System.out.println(stu.getRollno() + " "
                    + stu.getName() + " "
                    + stu.getDepartment());
        }
		 tx.commit();
		 session.close();
		
		
	}

	@Override
	public void getAllStudents() {
		Session session = sessionFactory.openSession();
		String sql = "select * from Students";
		List<StudentN> list = session.createNativeQuery(sql, StudentN.class).list();
		for(StudentN stu:list) {
			System.out.println(stu.getRollno() + " "
                    + stu.getName() + " "
                    + stu.getDepartment());
		}
		session.close();
	}

	@Override
	public void updateStudent(int rollno, String department) {
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        String sql = "update Students set department = :department WHERE rollno = :rollno";

        NativeQuery query = session.createNativeQuery(sql);
        query.setParameter("rollno", rollno);
        query.setParameter("department", department);

        int rows = query.executeUpdate();
        
        System.out.println("updated "+rows+" row");
        tx.commit();
        session.close();

        if (rows > 0) {
            System.out.println("StudentN Updated Successfully");
        } else {
            System.out.println("StudentN Not Found");
        }
		
	}

	@Override
	public void deleteStudent(int rollno) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "delete from Students where rollno=:rollno";
		NativeQuery query = session.createNativeQuery(sql).setParameter("rollno", rollno);
		int rows=query.executeUpdate();
        tx.commit();
	    System.out.println("deleted "+rows);
		session.close();
		
	}

}
