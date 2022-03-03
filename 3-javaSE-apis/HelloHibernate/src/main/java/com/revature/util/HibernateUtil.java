package com.revature.util;

import org.hibernate.Session; // this comes from the Hibernate dependency
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	/**
	 * The purpose of this class is to handle startup ( DB Connection) and access
	 * Hibernate's  Session FActory interface and obtain a Session Object
	 */

	private static Session ses; // this is kind of like the Connection Interfce from the JDBC
	
	/**
	 * We will use SessionFactory Interface to create a configuration object which 
	 * will call the .configure method to establish the connection to the DB based on the creds 
	 * we supplied in that file.
	 */
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public static Session getSession() { // similar to getConnection()
		
		if (ses == null) {
			ses = sf.openSession();
		}
		return ses; // return a connection to the database and use it to perform ops on the DB
	}
	
	public static void closeSes() {
		/**
		 * Ideally when we close a session it frees up that connection to the DB 
		 * and returns is to the connection pool so that is can be used by another
		 * thread or operation.
		 */
		ses.close();
	}
	
	
}
