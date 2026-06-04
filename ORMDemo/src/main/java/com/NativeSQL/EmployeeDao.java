package com.NativeSQL;

public interface EmployeeDao {
	
	 void saveEmployee();
	
    void getEmployee(int EmpId);
    
    void getAllEmployees();
    
    void  deleteEmployee(int EmpId);
//    
//    List<Employee>  getEmployeePagination(int start,int count);

	void updateEmployee(int EmpSalary , int EmpId);
	
}
