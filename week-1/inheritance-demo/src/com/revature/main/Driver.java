package com.revature.main;

import com.revature.model.Animal;
import com.revature.model.Dog;

public class Driver {

	public static void main(String[] args) {
		Dog d = new Dog("Fido", "Steak", "Bark!", 3, false);
		
		d.eat();
		d.fetch();
		d.sleep();
		
		// You can use Animal variables to refer to Dog objects, because Dogs are Animals
		// Inheritance -> Dog IS-AN Animal
		Animal a = new Dog("Sparky", "Corned beef", "Woof!", 4, false);
		
		a.eat();
		a.sleep();
		
		// We can't call fetch, even though the object we are referring to is a Dog, because we are using an Animal reference variable
		// The Animal reference variable only has access to the methods and properties defined within the Animal class
		// a.fetch();
		
		// We can use casting to help us out
		if (a instanceof Dog) {
			// #1
			Dog myDog = (Dog) a;
			myDog.fetch();
			
			// #2
			((Dog) a).fetch(); // downcasting (going from a less specific type to a more specific type
			
			// Two different types of casting
			// 1. primitive casting -> widening and narrowing
			// 2. reference casting -> upcasting and downcasting
		}
	}

}
