package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {
	
	private int id;
	private double balance;
	private int accOwner; // could be some type of ArrayList with all the user id's...just an idea
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
	public Account(int id, double balance, int accOwner, boolean isActive) {
		super();
		this.id = id;
		this.balance = balance;
		this.accOwner = accOwner;
		this.isActive = isActive;
	}
	
	// What if we create an Account from the console?
	// We need this constructor in the case that we instantitae the Account in the Java Program.
	// Then we send it to the database which assigns a Primary Key. (Serial Primary Key)
	// When we return the object from the database, it will have its assigned ID
	public Account(double balance, int accOwner, boolean isActive) {
		super();
		this.balance = balance;
		this.accOwner = accOwner;
		this.isActive = isActive;
	}
	
	// getters & setter for the new field
	// re-generate hashCode, equals and toString

	public int getAccOwner() {
		return accOwner;
	}

	public void setAccOwner(int accOwner) {
		this.accOwner = accOwner;
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
		return Objects.hash(accOwner, balance, id, isActive);
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
		return accOwner == other.accOwner && Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& id == other.id && isActive == other.isActive;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", accOwner=" + accOwner + ", isActive=" + isActive + "]";
	}

	
	
}
