package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Dao1;

@Service
public class Service1 {
	
	@Autowired // dependency injection via autowiring + component scanning
	private Dao1 dao1; // Spring automatically understands that a DAO object BELONGS to this class so that we can
					   // call its methods in the below service methods.
	
	public String calculateSomething() {
		
		// rigorous business logic here...
		return dao1.retrieveSomething(); // call to the Dao layer
		
	}
	

}
