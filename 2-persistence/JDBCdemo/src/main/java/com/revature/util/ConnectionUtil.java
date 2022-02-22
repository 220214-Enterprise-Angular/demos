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
 * Singleton Design Pattern:
 * - purpose: control object creation, limiting the number of instances of this class to 1
 *
 */
public class ConnectionUtil {
	
	private static Logger logger = Logger.getLogger(ConnectionUtil.class);
	
	// import the Connection interface from java.sql
	private static Connection conn = null;
	
	// singlton's have private constructors
	private ConnectionUtil() {
		
	}
	
	// every singlton class has a public static getInstance() method
	public static Connection getConnection() {
		
		try {
			// first we check is an instance exists
			if (conn !=null && !conn.isClosed()) {
				// if an instance exists, we return the static connection declared on line 17
				logger.info("returned the re-used connection object");
				return conn;
			}
		} catch (SQLException e) {
			logger.error("we failed to re-use the connection");
			e.printStackTrace();
			return null;
		}
		
		// Here we actually establish a connection to the database by passing the appropriate credentials to  
		// connect to it (username & password + JDBC url)
		
		Properties prop = new Properties(); // ctrl + shift + o will auto import from java.util
			
		String url = "";
		String username = "";
		String password = "";
		
		
		try {
			
			// The Properties object uses the FileReader object to read all the values from the document that we've specified at the path below
			prop.load(new FileReader("C:\\Users\\SophieGavrila\\Desktop\\demos\\2-persistence\\JDBCdemo\\src\\main\\resources\\application.properties")); // import FileReader from java.io
			
			url = prop.getProperty("url"); // we are able to assign the string value of the value of the "url" field in the application.properties file
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			
			conn = DriverManager.getConnection(url, username, password); 
			// IF the above line is successful we WON'T hit any of these catch clauses and the code will execute line 80 (return conn)
			logger.info("Successfully connected to DB");
			
		} catch (SQLException e) {
			logger.error("Can't establish connection to DB with given credentials");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			logger.warn("couldn't read from application.properties at specified path");
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn("Something wrong with application.props file");
			e.printStackTrace();
		}
		
		return conn;
	}
}
