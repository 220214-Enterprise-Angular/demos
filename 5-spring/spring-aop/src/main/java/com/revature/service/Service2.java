package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Dao2;

@Service
public class Service2 {
	
	@Autowired // dependency injection via autowiring + component scanning
	private Dao2 dao2; // Spring automatically understands that a DAO object BELONGS to this class so that we can
					   // call its methods in the below service methods.
	
	public String calculateSomething() {
		
		// rigorous business logic here...
		return dao2.retrieveSomething(); // call to the Dao layer
		
	}
	

}
