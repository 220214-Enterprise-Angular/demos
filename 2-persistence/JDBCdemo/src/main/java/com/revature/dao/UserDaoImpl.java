package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

/**
 * This class is part of the DAO design pattern and this class' reponsibility is
 * for separating persistence logic from the rest of the application (separated
 * from the business layer)
 * 
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
			ResultSet rs; // an interface from JDBC API used to iterate over the data returned
			// We wil extract the primary key from the object created in the DB
			
			if ((rs = stmt.executeQuery()) != null) {

				// if we reutrn data, we iterate over it 
				rs.next(); // moves the cursor of the ResultSet over the information
				
				// capture the PK and save it as the user's ID
				int id = rs.getInt(1); // capture the value of the first column (which is id) of the record that's returned.
				
				// log that we successfully grabbed an ID
				logger.info("Returned User with ID of " + id);
				
				// if we're successfull, the method returns here and pops off the stack frame (method is DONE!)
				return id;
			}
			
		} catch (SQLException e) {
			logger.error("Unable to insert User - SQL exception thrown");
			e.printStackTrace();
		}
		
		// we can return a negative number to indicate that something went wrong in the insertion of a User into the DB
		return -1;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
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
