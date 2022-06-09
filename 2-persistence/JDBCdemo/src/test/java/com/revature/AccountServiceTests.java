package com.revature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.AccountDaoImpl;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.AccountService;

public class AccountServiceTests {
	
	private AccountService aserv;
	
	private AccountDaoImpl mockDao;
	
	@Before
	public void setup() {
	
		mockDao = mock(AccountDaoImpl.class);
		aserv = new AccountService(mockDao);
		
	}
	
	@After // after every unit test 
	public void teardown() {
		
		aserv = null;
		mockDao = null;
		
	}
	
	// unit tests
	
	// When we call the Account Service's findByOwner() method which returns all accounts that belong to a user
	// does it properly return them? 
	
	@Test // annotations provide information to the compiler
	public void testFindByOwner_returnAccountList() {
		
		User dummyUser = new User();
		dummyUser.setId(42);
		
		List<Account> bobsAccounts = new LinkedList<>();

		// create Account b, and Account a, then add them to the linkedList
		Account a = new Account(1, 100, dummyUser.getId() , false);
		Account b = new Account(2, 200, dummyUser.getId(), false);
		
		bobsAccounts.add(a);
		bobsAccounts.add(b);
		
		dummyUser.setAccounts(bobsAccounts);
		
		// The DAO is always right....in the case of unit tests with mockito 
		// we're pretending that the DB returns the right data to the DAO, which the DAO gives the Service
		when(mockDao.findByOwner(dummyUser.getId())).thenReturn(bobsAccounts);
		
		// the returned accounts from findByOwner(bob.getId);
		// returns the equivelent account list that belongs to the object already
		
		List<Account> returnedAccounts = aserv.findByOwner(dummyUser.getId());
		
		// assert that the returnedAccounts is still = to the accounts we initially set to bob
		assertEquals(bobsAccounts, returnedAccounts);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
