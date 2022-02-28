package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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
		SELECT accounts.id, accounts.balance, accounts.active 
			FROM accounts
				INNER JOIN users_accounts_jt 
					ON accounts.id = users_accounts_jt.acc_owner 
						WHERE users_accounts_jt.acc_owner = ?
	 */
	@Override
	public List<Account> findByOwner(int accOwnerId) { // find all the accounts based on an owner ID
		
		// setup a list to add the accounts to that we collect.  return this list at the end
		List<Account> ownedAccounts = new LinkedList<Account>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
		
			
			String sql = "SELECT accounts.id, accounts.balance, accounts.active \r\n" + 
					"			FROM accounts\r\n" + 
					"				INNER JOIN users_accounts_jt \r\n" + 
					"					ON accounts.id = users_accounts_jt.account  \r\n" + 
					"						WHERE users_accounts_jt.acc_owner = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, accOwnerId);

			
			// Grab a ResultSet obj
			ResultSet rs = stmt.executeQuery();
			
			// there could be 5 records, or there could be 0 records
			while (rs.next()) {
				
				int id = rs.getInt("id");
				double balance = rs.getDouble("balance");
				boolean isActive = rs.getBoolean("active");
				
				// instantitate the account object
				Account a = new Account(id, balance, accOwnerId, isActive);
				
				// add the account to the list
				ownedAccounts.add(a);
			}
			
			
		} catch (SQLException e) {
			logger.warn("Unable to fetch accounts from DB with the owner id of " + accOwnerId);
			e.printStackTrace();
		}
		
		return ownedAccounts;
	}
	
	public static void main(String[] args) {
		AccountDaoImpl adao = new AccountDaoImpl();
		
		int pk = adao.insert(new Account(610, 2, true));
		
		System.out.println(pk);
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
