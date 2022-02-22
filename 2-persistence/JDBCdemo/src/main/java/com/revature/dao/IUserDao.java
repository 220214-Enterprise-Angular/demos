package com.revature.dao;

import java.util.List;

import com.revature.models.User;

/**
 * The DAO or (Data Access Object) consists of a DAO interface which outlines the CRUD methods to be performed on a particular object
 *
 */
public interface IUserDao {

	// Create:
	int insert(User u); // insert a User object and return the generated Primary key
	// all of that functionality will be implemented in the DAO Implenetation Class called UserDaoImpl
	
	// Read: 
	User findById(int id); // return user object by ID
	User findByUsername(String username); // findNByUsername - return User based on the username you pass through
	List<User> findAll(); // return all User's in the DB
	
	// Update:
	boolean update(User u); // return whether the update was successful or not

	// Delete:
	boolean delete(int id); // return whether the delete was successful or not
}
