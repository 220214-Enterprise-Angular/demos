package com.revature.menu;

import java.sql.SQLException;

import com.revature.exceptions.BlankLoginCredentialsException;
import com.revature.model.User;
import com.revature.service.LoginService;

public class LoginMenu implements Menu {

	private LoginService ls;
	
	public LoginMenu() {
		this.ls = new LoginService();
	}
	
	@Override
	public void display() {
		
		boolean notValid = true;
		while (notValid) {
			System.out.println("Enter a username: ");
			String username = Menu.sc.nextLine();
			
			System.out.println("Enter a password: ");
			String password = Menu.sc.nextLine();
			
			try {
				User u;
				
				u = this.ls.login(username, password); 
				// might throw BlankLoginCredentialsException
				
				
				if (u.getRole().equals("Admin")) {
					(new AdminMenu()).display();
				}
				
				
				notValid = false;
			} catch (SQLException e) {
				System.out.println("ERROR CONNECTING TO DATABASE");
			} catch (BlankLoginCredentialsException e) {
				System.out.println(e.getMessage());
				notValid = true;
			}
		}
		
		
		
	}

}
