package com.revature.services;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.AccountDaoImpl;
import com.revature.dao.IAccountDao;
import com.revature.models.Account;
import com.revature.models.User;

public class AccountService {
	
	// this is the dependency that the service uses to perform CRUD ops on Account objects
	private IAccountDao adao;
	
	private static Scanner scan = new Scanner(System.in);
	// The Service layer depends on the DAO to perform crud operations, and adds extra business logic
	
	public AccountService(AccountDaoImpl adaoImpl) {
		
		this.adao = adaoImpl;
	}
	
	/**
	 * Maybe in some menu, a user has the option to enter a number that will invoke thi
	 * method.  Then we pass the user object (of the user who's opening the account)
	 * into the method -- the accOwner id == user's id
	 * 
	 */
	public Account openAccount(User u) {
		
		// prompt the user to enter an initial deposit amount
		System.out.println("Please enter the initial amount you would like to deposit:");
		
		// capture the deposit value
		double deposit = scan.nextDouble();
		
		// instantiate an Account with the initial deposit
		Account a = new Account(deposit, u.getId(), false); // it's inactive until a manager looks at
 		
		// call the insert method and return the Primary Key generated by the DB
		int pk = adao.insert(a);

		// set the acount's id = to the PK returned
		a.setId(pk);
		
		// return the account object 
		return a;
	}
	
	
	public List<Account> findByOwner(int userId) {
		
		return adao.findByOwner(userId);
		
	}
	

	public boolean deposit(double depositAmount) {
		
		// some rigorous logic.....
		
		return true;	
	}
	
	

}
