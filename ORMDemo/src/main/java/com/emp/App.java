package com.emp;

import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		EmployeeDao employeeDao = context.getBean(EmployeeDao.class);

//		System.out.println("Enter the employee details");
		Scanner s = new Scanner(System.in);
//
//		System.out.println("Enter EmloyeeID , Employee Name and Email");

//		int empID = s.nextInt();
//		String empName = s.next();
//		String empDepartment = s.next();
//		int empSalary = s.nextInt();
//		String empEmail = s.next();
//
//		Employee obj1 = new Employee();
//		obj1.setEmpID(empID);
//		obj1.setEmpName(empName);
//		obj1.setEmpEmail(empEmail);
//		obj1.setEmpDepartment(empDepartment);
//		obj1.setEmpSalary(empSalary);
//
//		employeeDao.saveEmployee(obj1);
//		Employee obj2 = employeeDao.getEmployee(empID);
//
//		System.out.println(obj2.getEmpID());
//		System.out.println(obj2.getEmpName());
//		System.out.println(obj2.getEmpDepartment());
//		System.out.println(obj2.getEmpEmail());
//		System.out.println(obj2.getEmpSalary());
//
//		employeeDao.getAllEmployees();

		System.out.println("Select the options to various operations of employee data : ");
		System.out.println("1. Get All Employees Name starts with 'A' ");
		System.out.println("2. Get one Employee- Enter the ID");
		System.out.println("3. Get the Employee salary details ");
		System.out.println("4. Get Employee whose salary > 40000");
		System.out.println("5. Get Employee whose salary < 30000");
		System.out.println("6. Get Employees records (Pegination)");
		System.out.println("7. Delete a Employee");
		int key = s.nextInt();

		switch (key) {
		case 1:
			System.out.println("-------------------------------------");
			List<Employee> obj3 = employeeDao.getAllEmployees();
			System.out.println("List of all the employees : ");
			obj3.forEach(employee -> {

				System.out.println("Employee ID : "+employee.getEmpID());
				System.out.println("Name : "+employee.getEmpName());
				System.out.println("Depart : "+employee.getEmpDepartment());
				System.out.println("Email : "+employee.getEmpEmail());
				System.out.println("Salary : "+employee.getEmpSalary());
				System.out.println("------------------------------");
			});

			break;
		case 2:
			System.out.println("Enter the employee Id to get data: ");
			int EmpId = s.nextInt();
			 Employee employee = employeeDao.getEmployee(EmpId);
			 System.out.println("Employee ID : "+employee.getEmpID());
				System.out.println("Name : "+employee.getEmpName());
				System.out.println("Depart : "+employee.getEmpDepartment());
				System.out.println("Email : "+employee.getEmpEmail());
				System.out.println("Salary : "+employee.getEmpSalary());
				System.out.println("------------------------------");
			 
			break;
		case 3:
			System.out.println("Enter the Employee name to get data: ");
		    String name = s.next();
		    List<Employee> employees = employeeDao.fetchEmployeeSalary(name);

		    employees.forEach(emp -> {

		        System.out.println("Employee ID : " + emp.getEmpID());
		        System.out.println("Name : " + emp.getEmpName());
		        System.out.println("Depart : " + emp.getEmpDepartment());
		        System.out.println("Email : " + emp.getEmpEmail());
		        System.out.println("Salary : " + emp.getEmpSalary());

		        System.out.println("---------------------------");
		    });
			
			
			break;
		case 4:
			
			List<Employee> maxSalaryEmployees = employeeDao.maxEmployeeSalary();

		    maxSalaryEmployees.forEach(emp -> {
		        System.out.println("Employee ID : " + emp.getEmpID());
		        System.out.println("Name : " + emp.getEmpName());
		        System.out.println("Depart : " + emp.getEmpDepartment());
		        System.out.println("Email : " + emp.getEmpEmail());
		        System.out.println("Salary : " + emp.getEmpSalary());
		        System.out.println("---------------------------");
		    });
		    
			break;
		case 5:
			List<Employee> minSalaryEmployees = employeeDao.minEmployeeSalary();
		    minSalaryEmployees.forEach(emp -> {
		        System.out.println("Employee ID : " + emp.getEmpID());
		        System.out.println("Name : " + emp.getEmpName());
		        System.out.println("Department : " + emp.getEmpDepartment());
		        System.out.println("Email : " + emp.getEmpEmail());
		        System.out.println("Salary : " + emp.getEmpSalary());
		        System.out.println("---------------------------");
		    });
		        
			break;
		case 6:
			System.out.println("Enter the start and end EmpId numbers : ");
			try {
				int start = s.nextInt();
				int count = s.nextInt();
				List<Employee> data = employeeDao.getEmployeePagination(start, count);
				System.out.println(data);
				data.forEach(emp -> {
			        System.out.println("Employee ID : " + emp.getEmpID());
			        System.out.println("Name : " + emp.getEmpName());
			        System.out.println("Department : " + emp.getEmpDepartment());
			        System.out.println("Email : " + emp.getEmpEmail());
			        System.out.println("Salary : " + emp.getEmpSalary());
			        System.out.println("---------------------------");
			    });
			} catch (Exception e) {
				System.out.println("Error : " + e.getMessage());
			}
			break;
		case 7 : 
			
			System.out.println("Enter the employee Id to delete data: ");
			int id = s.nextInt();
			employeeDao.deleteEmployee(id);
			break;
		default:
			System.out.println(" Invalid input entered! ");
			break;
		}

		

		s.close();
	}
}