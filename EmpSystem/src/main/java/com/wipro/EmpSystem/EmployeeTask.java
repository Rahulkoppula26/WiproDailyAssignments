package com.wipro.EmpSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class EmployeeTask {

		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);

			System.out.println("Enter employee details!");
			System.out.println("enter new  name to be updated : ");
			String name = s.next();
			System.out.println("enter eid : ");
			int eid = s.nextInt();


			String URL = "jdbc:mysql.://localhost:3306/wiproj2ee";  // "jdbc:oracle:thin:@localhost:1521:xe";
			String USERNAME = "root";
			String PASSWORD = "@Rahul77";
			String query = "update employee set ename=? where eid=?";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); // step 1
				Connection connobj = DriverManager.getConnection(URL, USERNAME, PASSWORD); // step2
				PreparedStatement statement = connobj.prepareStatement(query);
				
				statement.setInt(2, eid);
				statement.setString(1, name);
				
				statement.executeUpdate();// executing the query
				

			} catch (Exception e) {
				System.out.println(e);
			}
			// mention Drive package
			// DriverMnager
			// Create database connection using driver
			// execute query using statement/preparestatement
			// resultset or output

		}
	}
