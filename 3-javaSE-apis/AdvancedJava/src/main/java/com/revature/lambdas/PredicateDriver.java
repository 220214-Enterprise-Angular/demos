package com.revature.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateDriver {
	
	public static void main(String[] args) {
		
		Employee abby = new Employee("Abby Adams", 40); // jr employees less than 30, sr employees >= 30
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
		
		// external class that implements the Predicate interface
		printEmployeesGreaterThan30(employees, new EmployeeAgeChecker());
		
		// anonymous class that implements Predicate interface
		printEmployeesGreaterThan30(employees, new Predicate<Employee>() {

			@Override
			public boolean test(Employee e) {
				return e.getAge() >= 30 ? true : false;
			}		
		});
		
		// lambda that provides the functionality for the test() method from Predicate interface
		printEmployeesGreaterThan30(employees, e -> e.getAge() >= 30);
		
		// Primitive Functional Interface
		IntPredicate greaterThanOrEqualTo30 = i -> i >= 30;
		int someVar = 500;
		System.out.println("Is " + someVar + " greater than or equal to 30?: " + greaterThanOrEqualTo30.test(someVar));
		
		// Predicate Chaining
		IntPredicate lessThan100 = i -> i < 100;
		System.out.println("Is " + someVar + " greater than or equal to 30 AND less than 100?: " + greaterThanOrEqualTo30.and(lessThan100).test(someVar));
		
	}
	/**
	 * params: List of employes
	 * 		  - a condition to be passed in order to be printed
	 * 
	 * Predicate has a method called test which returns a boolean value 
	 */
	private static void printEmployeesGreaterThan30(List<Employee> employees, Predicate<Employee> ageCondition) {
		
		employees.forEach(e -> {
			
			if (ageCondition.test(e)) {
				System.out.println(e + " passed the predicate age condition");
			}
		});
	}
}
// external class
class EmployeeAgeChecker implements Predicate<Employee> {

	@Override
	public boolean test(Employee e) {
		return e.getAge() >= 30 ? true : false;
	}
	
}