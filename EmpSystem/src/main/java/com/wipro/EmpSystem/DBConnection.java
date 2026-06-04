package com.wipro.EmpSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
		static Connection connect = null;
		
		public static Connection getDatabase() throws ClassNotFoundException, SQLException {
			if(connect == null) {
				String URL = "jdbc:mysql://localhost:3306/wiproj2ee";
				String USERNAME = "root";
				String PASSWORD = "@Rahul77";
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				return connect;

			}
			else {
				return connect;
			}
		}

	}


