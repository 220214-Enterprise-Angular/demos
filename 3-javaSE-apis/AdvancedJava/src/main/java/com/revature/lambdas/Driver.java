package com.revature.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Driver {

	public static void main(String[] args) {

		Employee abby = new Employee("Abby Adams", 40);
		Employee bob = new Employee("Bob Briggs", 22);
		Employee carter = new Employee("Carter Cobb", 20);
		Employee doug = new Employee("Doug Doberman", 52);
		Employee emily = new Employee("Emily Evanson", 34);
		
		// instantiate an ArrayList
		List<Employee> employees = new ArrayList<>();
		
		employees.add(emily);
		employees.add(carter);
		employees.add(abby);
		employees.add(doug);
		employees.add(bob);
		
		/**
		 * A Lambda expression is a short block of code which takes in parameters and returns a value.
		 * Lambda Expressions are similar to methods but they don't have an name
		 */
		employees.forEach(e -> System.out.println(e));
		
		// the old way with an enhanced for-loop
		for (Employee e : employees) {
			System.out.println(e);
		}
		
		// multiple lines in our lambda functionality?
		employees.forEach(e -> {
			// mutliple lines are now allowed (notice the curly brackets)
			System.out.println("Name is "+ e.getName());
			System.out.println("Age is "+ e.getAge());
			System.out.println();
		});
		
		// forEach can take in an instance of a class that has implemented the Consumer Interface
		// forEach can take in an Anonymous Class that implements the consumer Interface
		// forEach can simply use a lambda described the implementation of the accept() method that comes from the Consumer Functional Interface	
	
//		Collections.sort(employees); // we haven't implemented the Comparable interface and overriden the compareTo() method!
	
		// External class that implements Comparator
		Collections.sort(employees, new NameSorter());
		
		// Anonymous Class:
		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) { // instantiating an anonymous class that implements Comparator
				// TODO Auto-generated method stub
				return e1.getName().compareTo(e2.getName()); 
			} 
		});
		
		// Lambda
		Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
		
		
		/**
		 * Find a way to sort the employees list by Age.
		 * 
		 * 1. Sort by creating a Comparator external class.
		 * 2. Sort by providing an Anonymous class.
		 * 3. Sort with a Lambda in 1 line.
		 * 
		 * Send a thumbs up in the reactions when you're done
		 */
		Collections.sort(employees, new AgeSorter());
		
		// anon class
		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				// TODO Auto-generated method stub
				return e1.getAge() - e2.getAge();
			}
		});
		
		// lambda way
		Collections.sort(employees, (e1, e2) -> e1.getAge() - e2.getAge());
		
		// COnsuymer Interface forces you to implement the accept() method
		
		// assign a lambda function to a variable
		Consumer<Employee> myMethod =  e -> System.out.println(e); // <- this is the implementation of the accept method
		
		employees.forEach(myMethod);
		
		// Method Referencing
		employees.forEach(System.out::println); 
		
	}	
}

class AgeSorter implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		
//		if (e1.getAge() < e2.getAge()) {	
//			return -1;
//		} else if (e1.getAge() > e2.getAge()) {
//			return 1;
//		} else {
//			return 0;
//		}
		
		// ternary operator makes it more concise
		return e1.getAge() - e2.getAge();
		
	}
}


// create the comparator class
class NameSorter implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return e1.getName().compareTo(e2.getName()); // we can compare two strings becasue the String class has overridden the compareTo
	}
}














