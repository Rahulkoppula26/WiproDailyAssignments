package com.emp;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
@Transactional
public class EmployeeDaoimpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void saveEmployee(Employee employee) {
		Session obj1 = sessionFactory.getCurrentSession();
		obj1.save(employee);
	}

	public Employee getEmployee(int empId) {
		Session sobj = sessionFactory.getCurrentSession();
		return sobj.get(Employee.class,empId);
		
	}


	public List<Employee> getAllEmployees() {
		Session sobj = sessionFactory.getCurrentSession();
//		return sobj.createQuery("from Employee",Employee.class).getResultList();
		
		Criteria criteria = sobj.createCriteria(Employee.class);
		criteria.add(Restrictions.ilike("empName", "A%"));
		return criteria.list();
		
		
		
	}
	 public void deleteEmployee(int empId) {
		Session sobj = sessionFactory.getCurrentSession();
		String hql = "DELETE FROM Employee WHERE id = :id";
		sobj.createQuery(hql)
		     .setParameter("id", empId)
		     .executeUpdate();
		System.out.println("Employee is deleted");
	}
	
	 public List<Employee> fetchEmployeeSalary(String empName) {
		    Session sobj = sessionFactory.getCurrentSession();
		    Criteria fetchEmp = sobj.createCriteria(Employee.class);
		    fetchEmp.add(Restrictions.ilike("empName", empName));
		    return fetchEmp.list();
		}
	 
	 public List<Employee> maxEmployeeSalary() {
		 Session sobj = sessionFactory.getCurrentSession();
		 Criteria fetchMaxEmp = sobj.createCriteria(Employee.class);
		 fetchMaxEmp.add(Restrictions.gt("empSalary", 40000));
			return fetchMaxEmp.list();
		 
	 }
	 public List<Employee> minEmployeeSalary() {
		 Session sobj = sessionFactory.getCurrentSession();
		 Criteria fetchMinEmp = sobj.createCriteria(Employee.class);
		 fetchMinEmp.add(Restrictions.lt("empSalary", 30000));
			return fetchMinEmp.list();
		 
	 }
	 public List<Employee> getEmployeePagination(int start, int count) {
		    Session sobj = sessionFactory.getCurrentSession();
		    Criteria c = sobj.createCriteria(Employee.class);  
		    c.setFirstResult(start);  
		    c.setMaxResults(count);  
		    List list=c.list();  
		    return list;
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}































