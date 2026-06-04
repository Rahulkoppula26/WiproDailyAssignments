package com.emp;

import java.util.List;

public interface EmployeeDao {
	
	 void saveEmployee(Employee employee);
	
    Employee getEmployee(int empId);
    
    List<Employee> getAllEmployees();
    
    List<Employee> fetchEmployeeSalary(String name);
    
    List<Employee> maxEmployeeSalary();
    
    List<Employee> minEmployeeSalary();
    
    void  deleteEmployee(int empId);
    
    List<Employee>  getEmployeePagination(int start,int count);
	
}
