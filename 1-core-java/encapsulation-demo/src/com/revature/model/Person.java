package com.revature.model;

// POJO design pattern
// "Plain old Java Object"
// 1. properties
// 2. parameterized constructor
// 3. no-args constructor
// 4. getters/setters
public class Person {

	private String firstName;
	private String lastName;
	private int age;
	
	public Person() {
	}
	
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	/*
	 * Getters (these are methods)
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public int getAge() {
		return this.age;
	}
	
	/*
	 * Setters (these are methods)
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
}
