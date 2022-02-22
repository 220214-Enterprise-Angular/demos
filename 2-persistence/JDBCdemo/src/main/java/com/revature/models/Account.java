package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {
	
	private int id;
	private double balance;
	private boolean isActive; // remember the instance variable names do NOT need to adhere
	
	public Account() {
		
	}
	
	/**
	 * To quickly create a class, right click and click Source >
	 * 
	 *  - Generate Constructors from Fields
	 *  - Generate Getters & Setters
	 *  - Generate hashCode & equals
	 *  - Generate toString()
	 */

	public Account(int id, double balance, boolean isActive) {
		super();
		this.id = id;
		this.balance = balance;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, id, isActive); // this way of hashing an object was introduced in the 7th version of Java (1.7)
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance) && id == other.id
				&& isActive == other.isActive;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", isActive=" + isActive + "]";
	}

}
