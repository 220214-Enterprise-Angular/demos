package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.SuperPrison;
import com.revature.util.HibernateUtil;

public class SuperPrisonDao {
	
	// insert
	public int insert(SuperPrison sp) {
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(sp);
		
		tx.commit();
		
		return pk;
	}
	
	// selectById
	public SuperPrison selectById(int id) {
		
		// we grab the session
		Session ses = HibernateUtil.getSession();
		
		// invoke a simple query
		SuperPrison sp = ses.get(SuperPrison.class, id);
		
		return sp;
	}
	
	
}
