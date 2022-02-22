package com.revature.services;

import com.revature.dao.IUserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.User;

public class UserService {
	
	// UserService DEPENDS on the UserDaoImpl...so therefore we will inject a dependency into this class
	private IUserDao udao = new UserDaoImpl();
	
	public User register(User u) {
		
		// tomorrow we're going to cover complex logic that we would add to check things like the
		// the User credentials that we're adding into the DB
		
		 int id = udao.insert(u); // the insert method returns the user's primary key
		
		 u.setId(id); // we're adding the newly found ID from the DB to the User object that was passed into the method.
		 
		 return u; // and then returning it!
	}
	
	
}
