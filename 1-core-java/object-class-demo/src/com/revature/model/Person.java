package com.revature.model;

import java.util.Objects;

// This class has
// 1. private properties
// 2. no-args constructor
// 3. parameterized constructor
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
	 * Overriding methods from Object class
	 * 
	 * YOU ABSOLUTELY SHOULD UNDERSTAND WHAT THESE 3 methods are and why you need to override them
	 * Whenever you create any sort of class (for modeling real world entities), you should be overriding these 3 methods
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}

	/*
	 * Getters/setters
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
