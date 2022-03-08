package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	/**
	 * The purpose of the HibernateUtil.java Helper File 
	 * is to handle startup (DB connection) and access Hibernate's 
	 * SessionFactory interface to obtain a Session Object.
	 */
	private static Session ses; // This is like the Connection Interface from JDBC
	
	/**
	 * We will use SessionFactory interface to create a configuration object which will 
	 * call the .configure method to establish the connection to the DB based on the creds we supplied in that file
	 */
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	/**
	 * The getSession() method is called in the DAO layer.
	 * This method obtains a JDBC connection which we can use
	 * to perform a transaction on our Database.
	 */
	public static Session getSession() { // similar to getConnection()
		
		if (ses == null) {
			ses =  sf.openSession();
		}
		
		return ses;
		
	}
	
	// this method will close an active session
	public static void closeSes() {
		/**
		 * When we close a session, it frees up that connection to the DB
		 * and returns it to the connection pool, so that it can be used
		 * by another thread or operation.
		 */
		ses.close();
		
	}
	
}
