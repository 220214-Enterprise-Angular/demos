package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements IAccountDao{
	
	private static Logger logger = Logger.getLogger(AccountDaoImpl.class);

	@Override
	public int insert(Account a) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// you don't NEED the schema infront of the table if you've already defined the schema in your application.properties
			String sql = "INSERT INTO accounts (balance, acc_owner, active) VALUES (?, ?, ?) RETURNING accounts.id";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1, a.getBalance()); // how do we extract the balance from the Account Obj that's being passed?
			stmt.setInt(2, a.getAccOwner());
			stmt.setBoolean(3, a.isActive());
			
			ResultSet rs;
			
			if ((rs = stmt.executeQuery()) != null) {

				rs.next();			
				int id = rs.getInt("id");
				return id; // if the insertion is successful, we return here
			}
		} catch (SQLException e) {
			logger.warn("Unable to insert Account object into the DB");
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * Select * from accounts;
	 */
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override // Select * from accounts where id = ?
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
				 * SELECT sophiag.accounts.id, sophiag.accounts.balance, sophiag.accounts.active 
			FROM sophiag.accounts
				INNER JOIN sophiag.users_accounts_jt 
					ON sophiag.accounts.id = sophiag.users_accounts_jt.acc_owner 
						WHERE sophiag.users_accounts_jt.acc_owner = 2;
	 */
	@Override
	public List<Account> findByOwner(int accOwnerId) { // find all the accounts based on an owner ID
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}
