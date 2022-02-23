package com.revature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.UserService;

/**
 * This is a test suite (so it's a group of unit tests for one Class (like a Service)
 * 
 * Here we're using Assertions form JUnit, and some methods and Classes from Mockito
 */
public class UserServiceTests {
	
	private UserService userv;
	
	private UserDaoImpl mockDao;
	
	private User dummyUser; // ctrl  + shift + o to auot-import
	
	@Before // this annotation ensures that this test is run before every single unit test below
	public void setup() {
		
		userv = new UserService();
		
		// Mock creates an object that has all the methods and properties of the class we're mocking (that's called a shell instance)
		mockDao = mock(UserDaoImpl.class); // Mockito's mock() method builds an object that is an exact replica of an object of the class we're mocking
		
		// our service layer depends on the dao
		userv.udao = mockDao; // setting the User Service's UserDaoImpl to the imposter class (the mockDao)
		
		// setup a dummy object a.k.a stub
		dummyUser = new User();
		dummyUser.setAccounts(new LinkedList<Account>()); // this is an empty list
		dummyUser.setId(0); // because all User objects created from the console have an id of 0 before they're persisted to the DB
	}
	
	@After // after every unit test
	public void teardown() {
		
		userv = null;
		mockDao = null;
		dummyUser = null;
		
	}
	// unit tests with a void return type and are annotated with @Test
	
	// We want to test that we are unable to register a user with an id > 0.
	// We want to test that IF we attempt to register a user with an id > 0, then our exception is thrown
	
	// you're expecting this exception to be thrown when the test runs
	@Test(expected=RegisterUserFailedException.class)
	public void test_name() {
		
		// set the dummyUser's id
		dummyUser.setId(1);
		
		// we need to define what happens WHEN the mockDao's method's are called
		/**
		 * WHEN the service layer's dao calls the findByUsername method,
		 * this is the data the mock dao should return.
		 * 
		 * thenReturn is the mock data we're providing in place of the actual data in the database.
		 */

	    when(mockDao.findByUsername(dummyUser.getUsername())).thenReturn(dummyUser); // return an empty object
	
		// invoke the method which we expect to throw the exception
		userv.register(dummyUser); 
	}
	
	@Test
	public void testRegisterUser_returnNewPkAsId() {
		
		// build a valid user to register
		dummyUser = new User(0, "spongebob", "pass", Role.Customer, new LinkedList<Account>());
		
		// we're going to fake the value of a primary key that the DB would generate		
		
		// randomly generate a number which we'll pretend that the DB geenrated
		Random r = new Random();
		int fakePk = r.nextInt(100); // sets the random number ot be anywhere between 1 - 100;
		
		System.out.println(fakePk);
		
		when(mockDao.findByUsername(dummyUser.getUsername())).thenReturn(new User());
		
		// we need to say that WHEN we insert the dummyUserm then return the randomly generated number as PK
		when(mockDao.insert(dummyUser)).thenReturn(fakePk);
		
		// register the user
		User registeredUser = userv.register(dummyUser);
		
		System.out.println(registeredUser.getId());
		
		// then check that the registered user's id is equal to the fakePK
		// we want to assert equality of the User's id that register() method returns.
		assertEquals(fakePk, registeredUser.getId());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
