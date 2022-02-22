package com.revature;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.UserService;

public class App {
	
	// we've instnatiated the UserService at the class level, so we can call on it in any of our methods below...
	private static UserService uservice = new UserService();

	private static Logger logger = Logger.getLogger(App.class);
	
	
	
	public static void main(String[] args) {
		
//		logger.info("Starting application");
//		
//		ConnectionUtil.getConnection();

		menu();
		
	}
	
	public static void menu() {
		
		
		ArrayList<Account> accounts = new ArrayList<>();
		// we're only passing in an empty array list to satisfy the constructor
		User tony = new User("TonyStark", "ironman", Role.Admin, accounts); // Here I'm just using a hard coded object to test my connection
		
		User registeredUser = uservice.register(tony); 
		System.out.println(registeredUser); 
		
		// Create a Scanner
		
		// Ask the user for their username
		
		// set the property of the user object equal to the info I'm getting from the Scanner
		
		
	}

}
