package com.revature;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.exceptions.RegisterUserFailedException;
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
//		ConnectionUtil.getConnection(); // for testing that you can indeed connect

		menu();
		
	}
	
	public static void menu() {
//	
//		ArrayList<Account> accounts = new ArrayList<>();
//		// we're only passing in an empty array list to satisfy the constructor
//		User wanda = new User("Wanda", "pass", Role.Admin, accounts); // Here I'm just using a hard coded object to test my connection
//		
//		User registeredUser = uservice.register(wanda); 
//		System.out.println(registeredUser); 
//		
		// Create a Scanner
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome! Please press 1 if you'd like to login, or 2 if you'd like to register:");
		
		// capture the input of the user:
		int input = scan.nextInt();
		
		// use sometype of control flow logic like a switch case of if statement to check the value
	
		// think about how you avoid mismatch exceptions likke what if they put in ABC instead of 1 or 2?
		
		if (input == 1) { // login
			
			int counter = 5;
			
			while (counter > 0) {
		
				System.out.println("Please enter your username:");
				String username = scan.next();
				
				System.out.println("Please enter your password:");
				String password = scan.next();
				
				User loggedInUser = uservice.login(username, password);
				
				if (loggedInUser == null) {
					System.out.println("username and password is incorrect, please try again");
					counter--; // this is giving them 5 tries before exiting the loop and ending the program
				} else {
					
					logger.info("successfully logged in user with the username " + loggedInUser.getUsername());
					counter = -1;
				} 
			}
			
			// once broken out of the loop 
			if (counter > -1) {
				System.out.println("Ending your chance at logging in, good bye!");
				System.exit(0);
			}
			
			// you can still do stuff here
			System.out.println("If you would like to make a deposit please press 3...");
			
			/// .....
			
		} else if (input == 2) {
			
			User newUser = new User();
			
			System.out.println("Enter a username to register with");
			String newUsername = scan.next();
			
			System.out.println("Enter a password for your account");
			String newPass = scan.next();
			
			// you would need some logic for the role
			newUser.setPwd(newPass);
			newUser.setUsername(newUsername);
			newUser.setRole(Role.Customer);
			
			try {
				uservice.register(newUser);
			} catch (RegisterUserFailedException e) {
				logger.warn(e.getMessage());
				// perform some more logic.....
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
