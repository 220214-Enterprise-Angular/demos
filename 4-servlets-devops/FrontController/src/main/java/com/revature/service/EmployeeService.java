package com.revature.service;

import java.util.Optional;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;

public class EmployeeService {
	
	// the service class relies on (depends on the DAO)
	private EmployeeDao edao;
	
	/**
	 * Dependency Injection by way of Constructor Injection
	 *
	 * Constructor injection is a sophisticated way on ensuring now EmployeeService
	 * object is instantiated without passing through an EmployeeDao object.
	 */
	public EmployeeService(EmployeeDao edao) {
		this.edao = edao;	
	}
	
	/**
	 * This method will erturn an Employee that has successfully logged in
	 * meaning that their username and password match a unique record in the DB.
	 * 
	 * Return  null if it DOESN'T match a record.
	 * 
	 * @param username - comes from a parameter from an HTML form
	 * @param password - comes from a parameter from an HTML form
	 * @return Employee object complete with the Employee's first & last name
	 */
	public Employee confirmLogin(String username, String password) {
		
		Optional<Employee> possibleEmp = edao.findAll()
				.stream()
				.filter(e -> (e.getUsername().equals(username) && e.getPassword().equals(password)))
				.findFirst();
		
		// IF the employee object is present, return it, otherwise return null;
		return (possibleEmp.isPresent() ? possibleEmp.get() : null); 
	}
	
	public int insert(Employee e) {
		return edao.insert(e);
	}

}
