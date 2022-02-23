package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * What is JDBC?
 * 
 * JDBC (Java Database Connectivity) is the Java API that manages 
 * connecting to a database, issuing queries and commands, 
 * and handling result sets obtained from the database
 * 
 * What is a Singleton Design Pattern? 
 * 
 * A Singleton Class is a software design pattern that ensures 
 * there will be one single instance of that class.
 * 
 * -- private constructors 
 * -- static field of an instance of the class to be returned 
 * -- leverage a public static getInstance() (our getInstance method is the getConnection() method
 * 
 * The connection to our DB will be established by a singleton class which will
 * contain all the necessary driver information (jdbc url, username, password).
 */
public class ConnectionUtil {
	
	private static Logger logger = Logger.getLogger(ConnectionUtil.class);
	
	// import the Connection interface from java.sql (JDBC API!)
	private static Connection conn = null;
	
	// Singleton's have private constructors
	private ConnectionUtil() {
		
	}
	
	// every Singleton class has a public static getInstance() method
	// This allows us to return the single instance that exists in the application
	public static Connection getConnection() { 
		
		try {
			// first we check is an instance exists (if it's NOT null, and ISN'T closed, we return the single instance
			if (conn !=null && !conn.isClosed()) {
				// if an instance exists, we return the static connection declared on line 17
				logger.info("returned the re-used connection object");
				return conn;
			}
			
			//...If it IS null and IS closed, we continue fown to line 65 and establish a connection to return
			
		} catch (SQLException e) {
			logger.error("we failed to re-use the connection");
			e.printStackTrace();
			return null;
		}
		
		// We use a Properties object to read from a file and scrape our credentials from it
		Properties prop = new Properties(); // ctrl + shift + o will auto import from java.util
			
		String url = "";
		String username = "";
		String password = "";
		
		try {
			// The Properties object uses the FileReader object to read all the values from the document that we've specified at the path below
			prop.load(new FileReader("C:\\Users\\SophieGavrila\\Desktop\\demos\\2-persistence\\JDBCdemo\\src\\main\\resources\\application.properties")); // import FileReader from java.io
			
			url = prop.getProperty("url"); // we are able to assign the string value of the value of the "url" field in the application.properties file
			username = prop.getProperty("username"); // These all correlate the the "key" of the key-value pairs in the application.properties file
			password = prop.getProperty("password");
			
			conn = DriverManager.getConnection(url, username, password); 
			// IF the above line is successful we WON'T hit any of these catch clauses and the code will execute line 94 (return conn)
			logger.info("Successfully connected to DB"); // If we've hit this line, we've successfully established a connection with the DB
			
		} catch (SQLException e) {
			logger.error("Can't establish connection to DB with given credentials");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			logger.warn("couldn't read from application.properties at specified path");
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn("Something wrong with application.properties file");
			e.printStackTrace();
		}
		// Return the established connection if no exceptions are thrown
		return conn;
	}
}
