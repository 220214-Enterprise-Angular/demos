package com.revature.dao;

import java.util.List;

import com.revature.models.Account;

/**
 * This outlines the CRUD methods for the Account Objects
 */
public interface IAccountDao {
	
	// Create:
	int insert(Account a);
	
	// Read:
	List<Account> findAll();
	Account findById(int id);
	List<Account> findByOwner(int accOwnerId);
	
	// Update:
	boolean update(Account a);
	
	// Delete:
	boolean delete(int id);
}
