package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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

		// Mock creates an object that has all the methods and properties of the class we're mocking (that's called a shell instance)
		mockDao = mock(UserDaoImpl.class); // Mockito's mock() method builds an object that is an exact replica of an object of the class we're mocking
		
		userv = new UserService(mockDao);
	
		// our service layer depends on the dao
		// setting the User Service's UserDaoImpl to the imposter class (the mockDao)
		
	}
	
	@After // after every unit test
	public void teardown() {
		
		userv = null;
		mockDao = null;
		dummyUser = null;
		
	}
	
	/**
	 * Happy Path Scenario: Everything works as expected
	 * Return full record of User from DB based on username/password combo
	 */
	@Test
	public void testSuccessfulLogin() {
		
		dummyUser = new User(12, "hawkeye", "arrows", Role.Employee, null);
		
		String loginUsername = "hawkeye";
		String loginPassword = "arrows";
		
		/**
		 * What method's get's called in the login method in the Service layer?
		 * How can we intercept the calls to the database? 
		 * 
		 * findByUsername() get's called by the Service Layer - let's mock it!
		 */
		
		// WHEN the mockDao's findByUsername() gets called, THEN return the dummyuser;
		when(mockDao.findByUsername(loginUsername)).thenReturn(dummyUser);
		
		User expectedUser = dummyUser;
		User actualReturnedUser =  userv.login("hawkeye", "arrows");
		
		assertEquals(expectedUser, actualReturnedUser);
		
	}
	
	/**
	 * Must return null if the username and password passed to 
	 * the login method are not the same as the username & 
	 * password of the User returned by the Login method.
	 */
	@Test
	public void testFailedLogin() {
		
		dummyUser = new User(12, "hawkeye", "arrows", Role.Employee, null);
		
		String loginUsername = "hawkeye";
		String loginPassword = "balloons";
		
		// WHEN the mockDao's findByUsername() gets called, THEN return the dummyuser;
		when(mockDao.findByUsername(loginUsername)).thenReturn(dummyUser);
		
		User actualReturnedUser = userv.login(loginUsername, loginPassword);
		
		// We should assume that the User returned by this method will be null 
		assertNull(actualReturnedUser);
	}
	
	
	/**
	 * Happy Path Scenario for registering a new user
	 * Test that we properly return the User with the id set 
	 * as whatever the DAO returns as the Primary Key
	 */
	@Test 
	public void testRegisterUser_returnNewPkAsId() {
		
		// build a valid user to register
		dummyUser = new User(0, "spongebob", "pass", Role.Customer, null);
		
		// we're going to fake the value of a primary key that the DB would generate		
		
		// randomly generate a number which we'll pretend that the DB geenrated
		Random r = new Random();
		int expectedId  = r.nextInt(100); // sets the random number to be anywhere between 1 - 100;
	
		
		// first the dao is called upon to check if the user's already in the DB
		// we return an empty user because we're pretending it ISN'T in the DB
		when(mockDao.findByUsername(dummyUser.getUsername())).thenReturn(new User());
		
		// we need to say that WHEN we insert the dummyUser then return the randomly generated number as PK
		when(mockDao.insert(dummyUser)).thenReturn(expectedId);
		
		// register the user (the returned value of the method)
		User registeredUser = userv.register(dummyUser);
		int actualId =  registeredUser.getId();
		
		// then check that the registered user's actual id is equal to the fakePK
		// we want to assert equality of the User's id that register() method returns.
		assertEquals(expectedId, actualId);

	}	
	
	
	/**
	 * Test that a RegisterUserFailedException is thrown 
	 * We don't use assertions in this case.  Instead we
	 * add an exception expectation and run it.
	 */
	@Test(expected=RegisterUserFailedException.class)
	public void testRegisterUser_idIsGreaterThanZero_throwsException() {
		
		// Set our stub to a User that we pretend has an ID > 0
		// and already exists in the DB
		dummyUser = new User(2, "wanda", "vision", Role.Admin, null);
		
		// when the dao calls the findByUsername() method, we return the
		// above user
		when(mockDao.findByUsername(dummyUser.getUsername())).thenReturn(dummyUser);
		
		userv.register(dummyUser); // this should throw an exception		
	}
	
	
}
