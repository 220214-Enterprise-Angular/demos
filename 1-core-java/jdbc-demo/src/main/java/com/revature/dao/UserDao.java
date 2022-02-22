package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;
import com.revature.utility.ConnectionUtility;

// The responsibility of a Dao (Data access object) class is to contain the
// code necessary for performing CRUD operations against a database
public class UserDao {

	public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
		
		try (Connection con = ConnectionUtility.getConnection()) {
			
			String sql = "SELECT * FROM users WHERE users.username = ? AND users.password = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, username); // question mark #1
			pstmt.setString(2, password); // question mark #2
			
			ResultSet rs = pstmt.executeQuery();
			// ResultSet represents the table of results from the SELECT query
			
			rs.next(); // iterates to the very first row
			// This query should always only ever have 1 result
			
			int id = rs.getInt("id");
			String un = rs.getString("username");
			String pw = rs.getString("password");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String role = rs.getString("role");
			
			User u = new User(id, un, pw, firstName, lastName, role);
			
			return u;
		}
		
	}
	
}
