package com.revature.main;

import com.revature.model.Circle;
import com.revature.model.Shape;
import com.revature.model.Square;
import com.revature.model.Triangle;

public class Driver {

	public static void main(String[] args) {
		
		Shape s1 = new Square("square", 5);
		
		System.out.println(s1.calculateArea());
		
		s1 = new Circle("circle", 2);
		
		System.out.println(s1.calculateArea());
		
		s1 = new Triangle("triangle", 10, 10);
		
		System.out.println(s1.calculateArea());
		// Runtime polymorphism

	}

}
