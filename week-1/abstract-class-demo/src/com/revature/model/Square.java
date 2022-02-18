package com.revature.model;

import java.util.Objects;

public class Square extends Shape {

	private double side;
	
	public Square(String name, double side) {
		super(name); // invoke the constructor in the superclass (which happens to be Shape)
		this.side = side;
	}
	
	@Override
	public double calculateArea() {
		return this.side * this.side;
	}

	/*
	 * Getters/setters
	 */
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	/*
	 * Object class methods
	 * - hashCode()
	 * - toString()
	 * - equals()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(side);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Square other = (Square) obj;
		return Double.doubleToLongBits(side) == Double.doubleToLongBits(other.side);
	}

	@Override
	public String toString() {
		return "Square [side=" + side + "]";
	}

}
