package com.revature;

import com.revature.inspection.*; // this is from an entirely external project
import com.revature.models.SuperVillain;

public class ReflectionTest {
	
	public static void main(String[] args) {
	
		// print all of the nonPublic & public fields of a class by importing the ClassInspector from my Reflection Framework
		
		// test is on my SuperVillain class
		
		
		ClassInspector.inspectClass(SuperVillain.class);
		
		
		// first, create the method in the classInspector to print  nonpublic fields
		
		// maven import the framework that I want to borrow the class from INTO this project
		
		// then, call the method and pass a Supervillain class
		
	}

}
