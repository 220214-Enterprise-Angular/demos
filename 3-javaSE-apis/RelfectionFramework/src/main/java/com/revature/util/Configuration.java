package com.revature.util;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * The purpose of this class is to have the User only provide a few
 * things in order for the ORM to establish a connection and build the tables
 * based on a list of User-Defined classes that the user passes to the ORM to
 * inspect and construct in the DB 
 */
public class Configuration {
	
	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	
	// a list of MetaModels of Classes is a property of a config object
	private List<MetaModel<Class<?>>> metaModelList; // for example, this is a placeholder for metamodels of SuperVillain, SuperPrison, Crime
	
	// constructor - addAnnotatedClass
	public Configuration addAnnotatedClasses(List<Class<?>> annotatedClasses) {
		
		// if the metaModelList is null, geenrate a new LinkedList
		if(metaModelList == null) {
			this.metaModelList = new LinkedList<MetaModel<Class<?>>>();
		}
		
		// iterate through the list of classes passed through
		for (Class clazz : annotatedClasses) {
			
			// call the of() method from the MetaModel class in order to generate a MetaModel obj of each class in the list
			this.metaModelList.add(MetaModel.of(clazz)); // this method procies a metamodel object because it calls the constructor
		}
		return this;
	}
	
	// how do we get all the meta models to process and build tables from ?
	public List<MetaModel<Class<?>>> getMetaModels() {
		// if this list is empty return emptyList(), otherwise return the list
		return (List<MetaModel<Class<?>>>) ((metaModelList == null) ? Collections.emptyList() : metaModelList);
	}

	// return a connection object
	public Connection getConnection(String dbUrl, String dbUsername, String dbPassword) {
		
		this.dbUrl = dbUrl;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
		
		// maybe establish a connection here with more logic
		
		// instead of returning null, return some connection to the database
		return null;
		
		// maybe built an ORM helper class that you would delegate this functionality to 
		// SRP - Single Responsibility Principle  (SOLID) 
		// in OOP  every class has 1 unique purpose, so technically we're currently violating this principle
		
		// in YOUR ORM's make a separate class responsible for connecting to the DB (like the HibernateUtil.java helper class
	}
	

}
