package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

/**
 * DAO Implementation Class
 * 
 * This class is part of the DAO design pattern and its responsibility is
 * for separating persistence logic from the rest of the application (separated
 * from the business layer a.k.a Service layer).
 */
public class UserDaoImpl implements IUserDao { // save with ctrl + shift + s

	private static Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Override
	public int insert(User u) {
		
		// Step 1. Capture the connection to the DB by calling the ConnectionUtil's getConnection() method
		Connection conn = ConnectionUtil.getConnection(); // import Connection interface from java.sql
		
		// Step 2. Generate a SQL statement to insert the User into the Database
		String sql = "INSERT INTO sophiag.users (username, pwd, user_role_name) VALUES (?, ?, ?) RETURNING sophiag.users.id";
		// we will provide the value for the ?'s using a JDBC method...
		
		try {
			
			// Step 3. Use a prepared statmenet to avoid SQL injection
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// STep 4 set all the values of the ?'s
			stmt.setString(1, u.getUsername()); // the 1 refers to the order of the ?'s in the prepared statement
			stmt.setString(2,  u.getPwd()); 
			
			// This is a work around to transpose a Java ENUM to a RDBMS ENUM....
			stmt.setObject(3, u.getRole(), Types.OTHER);
			
			// Step 5. Iterate over the returned values from the insert statement
			ResultSet rs; // ResultSet is an interface from JDBC API that allows us the behavior to iterate over the data returned
			// We wil extract the primary key from the object created in the DB
			
			if ((rs = stmt.executeQuery()) != null) { // rs = stmt.executeQuery will generate a record of data to iterate over

				// if we reutrn data, we iterate over it 
				rs.next(); // moves the cursor of the ResultSet over the information
				
				// capture the PK and save it as the user's ID
				int id = rs.getInt(1); // capture the value of the first column #1 (which is id) of the record that's returned.
				
				// log that we successfully grabbed an ID
				logger.info("Returned User with ID of " + id);
				
				// if we're successful, the method returns here and pops off the stack frame (method is DONE!)
				return id;
			}
			
		} catch (SQLException e) {
			logger.error("Unable to insert User - SQL exception thrown");
			e.printStackTrace();
		}
		
		// we can return a negative number to indicate that something went wrong in the insertion of a User into the DB
		// if we never returned from line 64
		return -1;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	// probably call this method in Login() and in register()
	@Override
	public User findByUsername(String username) {
		
		// temp User object which we'll set all of its properties = to the props returned from the DB
		User u = new User(); // by default this user has an id of 0
		
		// try with resources blocks close the connection after utilization 
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// SQL statement we use to execute against the DB
			String sql = "SELECT * FROM sophiag.users WHERE username = ?";
			
			// use a Prepared statement to avoid SQL injection attack
			PreparedStatement stmt = conn.prepareStatement(sql); 
			
			// set the value of the ? = to the username passed through
			stmt.setString(1, username);
			
			ResultSet rs; // DECLARING it, not intilializing it
			
			// stsmt.executeQuery returns an object
			// we assign the returned value to a ResultSet Object
			if ((rs = stmt.executeQuery()) != null) { // if no data is returned the object is empty
			
				// if it's not null, let's grab the properties of the object returned
				if (rs.next() == true) { // if it's an empty row, and there's no data to reutnr, then we skip this code
					// we always call this when data is returned
					// get the data!
					int id = rs.getInt("id"); //capture the id by indicating which column number (or name) the data comes from
					String returnedUsername = rs.getString("username");
					String  password = rs.getString("pwd");
					// Role is our custom ENUM name
					Role role = Role.valueOf(rs.getString("user_role_name")); // this checks to see if any of your declared ENUMS have the same string value
																			  // as what you returned.
					
					// set all the properties of the temp User created on line 89 = to what you retrieved
					u.setId(id);
					u.setUsername(returnedUsername);
					u.setPwd(password);
				}
				
			}	else { // in the case that the result set is null
				logger.info("The user with that Username does not exists");
				return u; // then we return an empty user object (created on line 89) -- its ID will be == 0;
			}

		} catch (SQLException e) {
			logger.warn("SQL Exception thrown - can't retrieve User from DB");
			e.printStackTrace();
		}

		return u; // this successfully returns the initlaized User object with the data returned
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
