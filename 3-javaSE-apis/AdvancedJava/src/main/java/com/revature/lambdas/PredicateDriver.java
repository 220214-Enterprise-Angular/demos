package com.revature.lambdas;

import java.util.ArrayList;
import java.util.List;
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
		
		printEmployeesGreaterThan30(employees, new isGreaterThan30());
		
		/**
		 * CHALLENGE
		 * Provide the predicate implementation via:
		 * 
		 * 1. Anonymous class
		 * 2. Lambda Expression
		 */
	}
	/**
	 * params: List of employes
	 * 		  - a condition to be passed in order to be printed
	 * 
	 * Predicate has a method called test which returns a boolean valu 
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
class isGreaterThan30 implements Predicate<Employee> {

	@Override
	public boolean test(Employee e) {
		return e.getAge() >= 30 ? true : false;
	}
	
}


















