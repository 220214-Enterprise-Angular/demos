package com.revature.model;

import java.util.Objects;

public class Triangle extends Shape {

	private double base;
	private double height;
	
	public Triangle(String name, double base, double height) {
		super(name);
		this.base = base;
		this.height = height;
	}

	@Override
	public double calculateArea() {
		return 0.5 * this.base * this.height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(base, height);
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
		Triangle other = (Triangle) obj;
		return Double.doubleToLongBits(base) == Double.doubleToLongBits(other.base)
				&& Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height);
	}

	@Override
	public String toString() {
		return "Triangle [base=" + base + ", height=" + height + "]";
	}
	
}
