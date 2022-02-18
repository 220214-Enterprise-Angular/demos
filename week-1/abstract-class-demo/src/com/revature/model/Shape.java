package com.revature.model;

import java.util.Objects;

// the abstract keyword can be used to make a class abstract
// Properties of an abstract class:
// 1. You can't instantiate an abstract class
// 2. It can contain both abstract methods AND concrete (implemented) methods
// 3. Can actually contain a constructor even though you can't directly instantiate it

// Summary => is like a regular class except it can't be instantiated and can contain abstract methods
public abstract class Shape {

	protected String name;
	
	public Shape(String name) {
		this.name = name;
	}
	
	// Abstract method
	// There is no body
	public abstract double calculateArea();
	
	// Concrete (implemented) methods
	// They have bodies
	/*
	 * Getters/setters
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * hashCode()
	 * equals()
	 * toString()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Shape [name=" + name + "]";
	}
	
}
