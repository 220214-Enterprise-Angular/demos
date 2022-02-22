package com.revature.utility;

import java.sql.Connection; // built into the Java Runtime library
// java.sql and javax.sql are JDBC packages
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class ConnectionUtility {
	
	public static Connection getConnection() throws SQLException {
		
		// Connection String
		// type of database = postgresql
		// host name = localhost
		// port = 5432
		// database name = postgres
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "password123";
		// Ideally YOU SHOULD NOT be hardcoding your database
		// credentials OR any sort of credentials
		// But for demonstration purposes, this is the easy way
		// You should ideally create environment variables
		// and store the credentials into those environment variables
		
		// Then, you can reference those environment variables using
		// System.getenv(<variable name>)
		
		DriverManager.registerDriver(new Driver());
			
		Connection con = DriverManager.getConnection(url, username, password);
		
		return con;
	}
	
}
