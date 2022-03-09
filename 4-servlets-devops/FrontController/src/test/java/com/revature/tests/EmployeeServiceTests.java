package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class EmployeeServiceTests {
	
	private EmployeeService eserv;
	private EmployeeDao mockdao;
	
	@Before // run before every test
	public void setup() {		
		// create a mock of the EmployeeDao
		mockdao = mock(EmployeeDao.class); // create a copy of the class, with no method implementation
		eserv = new EmployeeService(mockdao); // we pass the mock dao into the service layer object so it uses our imposter obj
	}
	
	@After // runs after every test
	public void teardown() {
		
		mockdao = null;
		eserv = null;	
	}
	
	// Happy Path Scenario: Everything works as it should. assertEquals(expected, actual)
	
	@Test
	public void testConfirmLogin_success() { 
		
		// 1. create a fake list of employees which the dao will return\
		Employee e1 = new Employee(20, "Bruce", "Banner", "thehulk", "green");
		Employee e2 = new Employee(21, "Clint", "Barton", "hawkeye", "arrows");
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		
		// 2. set up when-then scenario
		// WHEN the dao's findALl() is called, THEN RETURN the fake data
		when(mockdao.findAll()).thenReturn(employees);
		
		// Capture the actual output of the method
		Employee actual = eserv.confirmLogin("hawkeye", "arrows");
		Employee expected = e2; // this is because we EXPECT that the confirmLogin() method 
		// should find that Employee object
		
		// compare the EXPECTED output to the ACTUAL output
		assertEquals(expected, actual);
	}
	
	@Test
	public void testConfirmLogin_fail() {
		// test that when you pass in a username & password combo to the confirmLogin() method, it returns NULL
		// if no user within the "fake" database has that combo.
		// 1. create a fake list of employees which the dao will return
		Employee e1 = new Employee(20, "Bruce", "Banner", "thehulk", "green");
		Employee e2 = new Employee(21, "Clint", "Barton", "hawkeye", "arrows");
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		
		when(mockdao.findAll()).thenReturn(employees);
		
		Employee actual = eserv.confirmLogin("hawkeye", "swords"); // the wrong password

		assertNull(actual);
	}
	
	
}
