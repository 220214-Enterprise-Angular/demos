package com.revature.service;

import java.sql.SQLException;

import com.revature.dao.UserDao;
import com.revature.exceptions.BlankLoginCredentialsException;
import com.revature.model.User;

public class LoginService {
	
	private UserDao ud;
	
	public LoginService() {
		this.ud = new UserDao();
	}
	
	// The service will contain business logic
	// Check if username is blank or password is blank (not allowed)
	public User login(String username, String password) throws SQLException, BlankLoginCredentialsException {
		
		if (username.trim().equals("") || password.trim().equals("")) {
			throw new BlankLoginCredentialsException("Username and/or password cannot be blank");
		}
		
		User u = this.ud.getUserByUsernameAndPassword(username, password);
		
		return u;
	}

}
