package com.revature.main;

import java.util.Scanner;

import com.revature.model.Animal;
import com.revature.model.Calculator;
import com.revature.model.Cat;
import com.revature.model.Dog;
import com.revature.model.Elephant;

public class Driver {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Choose an Animal: ");
		System.out.println("1.) Animal");
		System.out.println("2.) Dog");
		System.out.println("3.) Cat");
		System.out.println("4.) Elephant");

		int choice = Integer.parseInt(sc.nextLine());

		Animal myAnimalReferenceVariable = null;

		if (choice == 1) {
			myAnimalReferenceVariable = new Animal();
		} else if (choice == 2) {
			myAnimalReferenceVariable = new Dog();
		} else if (choice == 3) {
			myAnimalReferenceVariable = new Cat();
		} else if (choice == 4) {
			myAnimalReferenceVariable = new Elephant();
		} else {
			System.exit(0);
		}

		myAnimalReferenceVariable.makeNoise();

		/*
		 * Calculator method overloading
		 */
		Calculator calc = new Calculator();
		System.out.println(calc.sum(10.5, 10.3));
		System.out.println(calc.sum(10.5, 10.3, 3.14));
		System.out.println(calc.sum(10.5, 10.3, 3.14, 54.3));
		System.out.println(calc.sum(10.5, 10.3, 3.14, 54.3, 343.23));
		System.out.println(calc.sum(10.5));
		System.out.println(calc.sum());
		
		System.out.println(calc.sum(10, 23));

		/*
		 * ===============================
		 */

//		Animal myAnimalReferenceVariable = new Animal();
//		myAnimalReferenceVariable.makeNoise(); // **GENERIC ANIMAL NOISES**
//		
//		myAnimalReferenceVariable = new Dog();
//		myAnimalReferenceVariable.makeNoise(); // Bark!
//		
//		myAnimalReferenceVariable = new Cat();
//		myAnimalReferenceVariable.makeNoise(); // Meow!
//		
//		myAnimalReferenceVariable = new Elephant();
//		myAnimalReferenceVariable.makeNoise(); // **GENERIC ANIMAL NOISES**

	}

}
