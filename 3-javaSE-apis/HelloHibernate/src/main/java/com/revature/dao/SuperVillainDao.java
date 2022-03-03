package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.models.SuperVillain;
import com.revature.util.HibernateUtil;

// CRUD methods!
public class SuperVillainDao {
	
	public int insert(SuperVillain vill) {
		
		// grab the session
		Session ses = HibernateUtil.getSession();
		
		// grab the transaction obj
		Transaction tx = ses.beginTransaction();
		
		// capture the pk
		int pk = (int) ses.save(vill);
		
		// commit the transaction
		tx.commit();
		
		// return the pk
		return pk;
		
	}
	
	// Read is the R in CRUD
	// select all and return all supervillains in the DB
	public List<SuperVillain> selectAll() {
		
		// HQL - Hibernate Query Language
		// combo of native SQL and OOP
		
		// grab the session
		Session ses = HibernateUtil.getSession();
		
		// create a query, save it to a List of SuperVillains
		List<SuperVillain> villList = ses.createQuery("from SuperVillain", SuperVillain.class).list();
		
		return villList;
		
	}

	public SuperVillain selectByName(String name) {
		
		// grab the session
		Session ses = HibernateUtil.getSession();
		
		// Native SQL
		// SuperVillain vill = (SuperVillain) ses.createNativeQuery("SELECT * FROM supervillains WHERE name = '" + name + "'", SuperVillain.class);
		
		
		// Criteria API
		// SuperVillain vill = (SuperVillain) ses.createCriteria(SuperVillain.class).add(Restrictions.like("name", name));
		
		
		// HQL - Hibernate Query Language - combo of SQL and OOP
		SuperVillain vill = (SuperVillain) ses.createQuery("from SuperVillain where name = '" +name+ "' ", SuperVillain.class);
 
		return vill;
	}
	
	
	// Update:
	public void update(SuperVillain vill) {
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.update(vill);
		
		tx.commit();
		
	}
}
