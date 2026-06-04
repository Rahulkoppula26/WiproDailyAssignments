package com.wipro.EmpSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TestDB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//EmployeeData
//		System.out.println("Enter employee details!");
//		System.out.println("enter eid : ");
//		int eid = sc.nextInt();
		
//		TestDB object to display the data
		TestDB t = new TestDB();
//		t.getEmployeeData(eid);
		t.getAllEmployees();
		
	}
	void getEmployeeData(int inputeid) {

		try {

			String query = "select * from employee where id=" + inputeid;
			Connection connect = DBConnection.getDatabase();
			Statement queryobj = connect.createStatement();
			ResultSet data = queryobj.executeQuery(query);
			System.out.println("Employee data is fetched :");
			if (data.next()) {
				
				System.out.println("Name : " + data.getString("employee_name")); // database column name ename
				System.out.println("Eid : " + data.getInt("id"));
				System.out.println("Salary : " + data.getInt("salary"));
				System.out.println("Department : " + data.getString(5)); // database column count number 3 is dept

			}

		} catch (Exception e) {
			System.out.println(e);
		}


	}
	
	void getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			String query = "select * from employee";
			Connection connect = DBConnection.getDatabase();
			Statement queryObj = connect.createStatement();
			ResultSet data = queryObj.executeQuery(query);
			while (data.next()) {
				
				   Employee obj=new Employee();
				     obj.setEid(data.getInt("id"));
				     obj.setDept(data.getString(5));
				     obj.setEname(data.getString("employee_name"));
				     obj.setSalary(data.getInt("salary"));
				   list.add(obj);
			}
			for(Employee emp:list) {
			System.out.println(emp);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
