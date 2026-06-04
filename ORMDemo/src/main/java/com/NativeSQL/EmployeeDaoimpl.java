package com.NativeSQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoimpl implements EmployeeDao{
              
	    @Autowired
	    private SessionFactory sessionFactory;

	   

	    public void getAllEmployees() {

	        Session session = sessionFactory.openSession();
	        String sql = "SELECT * FROM employee";    
	        List<Employee> list = session.createNativeQuery(sql, Employee.class).list();

	        for (Employee e : list) {
	            System.out.println(e.getEmpID() + " "
	                    + e.getEmpName() + " "
	                    + e.getEmpSalary());
	        }
	        session.close();
	    }
		// UPDATE
		public void updateEmployee(int EmpSalary,int EmpId) {

		    Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();

	        String sql = "UPDATE employee SET EmpSalary = :EmpSalary WHERE EmpId = :EmpId";

	        NativeQuery query = session.createNativeQuery(sql);
	        query.setParameter("EmpSalary", EmpSalary);
	        query.setParameter("EmpId", EmpId);

	        int rows = query.executeUpdate();
	         System.out.println("updated "+rows+" row");
	        tx.commit();
	        session.close();

	        if (rows > 0) {
	            System.out.println("Employee Updated Successfully");
	        } else {
	            System.out.println("Employee Not Found");
	        }
	    }	
		
		// DELETE
		public void deleteEmployee(int EmpId) {

			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String sql = "delete from employee where EmpId=:EmpId";
			NativeQuery query = session.createNativeQuery(sql).setParameter("EmpId", EmpId);
			int rows=query.executeUpdate();
	        tx.commit();
		    System.out.println("deleted "+rows);
			session.close();
		 }

		@Override
		public void saveEmployee() {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Employee e1 = new Employee();
			e1.setEmpID(584);
			e1.setEmpName("Rahul");
			e1.setEmpDepartment("IT");
			e1.setEmpEmail("rahul@gmail.com");
			e1.setEmpSalary(70000);

			session.save(e1);
			tx.commit();
			
		}


		@Override
		public void getEmployee(int EmpId) {
			Session session = sessionFactory.openSession();
			String sql = "select * from employee where EmpId=:EmpId";
			 NativeQuery<Employee> query = session.createNativeQuery(sql, Employee.class);
			    query.setParameter("EmpId", EmpId);
			    List<Employee> list = query.list();
			
			for (Employee e : list) {
	            System.out.println(e.getEmpID() + " "
	                    + e.getEmpName() + " "
	                    + e.getEmpSalary());
	        }
			 session.close();
		}      
}
	 































