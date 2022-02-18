package com.revature.main;

import java.util.Objects;

public class Person {

	private String firstName;
	private int age;
	
	public Person() {
	}
	
	public Person(String firstName, int age) {
		this.firstName = firstName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, firstName);
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
		return age == other.age && Objects.equals(firstName, other.firstName);
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", age=" + age + "]";
	}
	
}
