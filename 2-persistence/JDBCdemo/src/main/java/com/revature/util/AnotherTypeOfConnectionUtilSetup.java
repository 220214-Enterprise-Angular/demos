package com.revature.util;

import java.sql.Connection; // THIS IS JDBC!
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class AnotherTypeOfConnectionUtilSetup {

	private static Connection conn = null;

	private static final Logger log = Logger.getLogger(AnotherTypeOfConnectionUtilSetup.class);

	// Notice how weird this is...Only for singleton
	private AnotherTypeOfConnectionUtilSetup() {
		super();
	}

	// this is our getInstance() method
	public static Connection getConnection() {

		try {
			if (conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e) {
			log.error("We failed to reuse a Connection", e);
			return null;
		}

		/**
		 * How to construct your JDBC URL pulled straight from the postgres documentation
		 * jdbc:postgresql://host:port/database 
		 * -> If you're hosting it locally: jdbc:postgresql://localhost:5432/postgres?currentSchema=myschema 
		 * 
		 * -> IF YOUR SCHEMA HAS CAPITAL LETTERS jdbc:postgresql://localhost:5432/postgres?currentSchema="mySchema" remember
		 * that your HOST and your currentSchema will be different from this (ezpecially if you're connecting to AWS)
		 */

		// If you're on windows set these in "environment variables" > System variables > then set, for example:
		// DB_USERNAME equal to postgres, etc.... YOU MUST RESTART SPRINGTOOL SUITE BEFORE THE EFFECT CAN SET IN
		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USERNAME");
		String password = System.getenv("DB_PASSWORD");

		/*
		 * Environment Variables are key/value pairs. Many Operating Systems use
		 * Environment Variables to allow configuration information to be passed into
		 * applications.
		 * 
		 * The way to set an environment variable differs from one operating system to
		 * another. For example, in Windows, we use a System Utility application from
		 * the control panel, while in Unix (think macOS) we use shell scripts.
		 * 
		 * https://medium.com/chingu/an-introduction-to-environment-variables-and-how-to
		 * -use-them-f602f66d15fa
		 */

		// If the above statement is false, then we should instead return a new Connection....
		try {
			conn = DriverManager.getConnection(url, username, password);
			log.info("Database connection extablished!");
		} catch (SQLException e) {
			log.error("We failed to establish a Connection");
			return null;
		}

		return conn;

	}
}