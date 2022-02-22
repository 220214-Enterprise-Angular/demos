package com.revature.utility;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// This class will contain various test methods
// for the NumberUtility class
public class NumberUtilityTest {

	
	public static NumberUtility nu;
	// @Test: used to signify that a method is a test case
	// @BeforeAll: used to signify that a method is going to run
	// before all of the test case methods
	// @BeforeEach: used to signify that a method is going to run
	// before each test case
	// @AfterEach: used to signify that a method is going to run
	// after each test case
	// @AfterAll: used to signify that a method is going to run
	// after all of the test case methods
	
	@BeforeAll
	public static void setup() {
		nu = new NumberUtility();
		System.out.println("Runs once before all test methods in the class");
	}
	
//	@BeforeEach
//	public void init() {
//		System.out.println("Runs before each test method");
//	}
//	
//	@AfterEach
//	public void tearDown() {
//		System.out.println("Runs after each test method");
//	}
//	
//	@AfterAll
//	public static void done() {
//		System.out.println("Runs once after all test methods in the class");
//	}
	
	
	// We will write some unit tests inside of this class
	
	@Test
	public void testIsPrime_1_shouldBeFalse() {
		
		/*
		 * AAA
		 * 
		 * Arrange: set up the required objects/configurations
		 * Act: use (invoke) whatever you want to test
		 * Assert: check to see if the output is what you expected
		 * 
		 */
		
		// Arrange
//		NumberUtility nu = new NumberUtility();
		
		// Act
		boolean actual = nu.isPrime(1); // actual output
		
		// Assert
		boolean expected = false;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testIsPrime_13_shouldBeTrue() {
		// Arrange
//		NumberUtility nu = new NumberUtility();
		
		// Act
		boolean actual = nu.isPrime(13);
		
		// Assert
		Assertions.assertTrue(actual);
	}
	
	@Test
	public void testIsPrime_negative1000_shouldBeFalse() {
		// Arrange
//		NumberUtility nu = new NumberUtility();
		
		// Act
		boolean actual = nu.isPrime(-1000);
		
		// Assert
		Assertions.assertFalse(actual);
	}
	
}
