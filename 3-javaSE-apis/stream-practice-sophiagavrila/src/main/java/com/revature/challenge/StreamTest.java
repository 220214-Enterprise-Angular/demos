package com.revature.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.models.Address;
import com.revature.models.MobileNumber;
import com.revature.models.Student;
import com.revature.models.TempStudent;

public class StreamTest {

	public static void main(String[] args) {

		/*
		 * ============== Don't alter the code between lines 24 - 42 ==============
		 */

		Student student1 = new Student("Bob", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Student student2 = new Student("Alice", 20, new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Student student3 = new Student("Wally", 20, new Address("1236"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234"))); // (new MobileNumber("3333"), new
																					// MobileNumber("4444")));

		List<Student> students = Arrays.asList(student1, student2, student3);

		/*
		 * ========== Don't alter the code above (lines 24 - 42) ===============
		 */

		/***************************************************************************
		 * (1) Get the student with the name "Bob" and print his name to the console. If
		 * "Bob" does not exist, print "No student found". HINT: Store
		 * students.stream()...etc to an Optional<Student> in the case that the student
		 * doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
		 ****************************************************************************/

		Optional<Student> s = students.stream().filter(student -> student.getName().equals("Bob")).findFirst(); // terminal
																												// operator
																												// -
																												// ends
																												// the
																												// stream,
																												// returns
																												// an
																												// object
																												// found

		System.out.println((s.isPresent() ? s.get().getName() : "No Student Found"));

		/***************************************************************************
		 * (2) Get the student with matching address "1235" and print their name to the
		 * console. If the address does not exist, print "No student found". HINT: Store
		 * students.stream()...etc to an Optional<Student> in the case that the student
		 * doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
		 ****************************************************************************/

		Optional<Student> s1 = students.stream().filter(student -> student.getAddress().getZipcode().equals("1235"))
				.findFirst(); // terminal operator that returns the first value found

		System.out.println((s1.isPresent() ? s.get().getName() : "No Student Found"));

		/****************************************************************************
		 * (3) Get all the students that have the mobile number "3333" and print their
		 * names to the console.
		 *****************************************************************************/

		System.out.println("============= problem 3 below ===================");

		// Code your Solution here

		// store all the refernce variables of the students that jave mobile number 3333
		// to a list
		List<Student> sWith3333 = students.stream()
				// make sure that only students with the mobile number "3333" get stored here
				.filter(stdnt -> stdnt.getMobileNumbers() // this returns a list
						.stream().anyMatch(num -> num.getNumber().equals("3333")))
				// if you're checking for another value maybe open up another filter() with
				// another stream()
				.collect(Collectors.toList());

		// use either method referencing or a lambda expression to print out each
		// student's name from the list
		sWith3333.forEach(sd -> System.out.println(sd.getName()));

		/***************************************************************************
		 * (4) Get all student having mobile number "1233" and "1234" and print their
		 * names to the console.
		 ***************************************************************************/

		System.out.println("====== 4 ======");
		List<Student> sWith1233And1234 = students.stream()
				.filter(stdnt -> stdnt.getMobileNumbers()
						.stream().anyMatch(num -> num.getNumber().equals("1233")))
				.filter(stdnt -> stdnt.getMobileNumbers()
						.stream().anyMatch(num -> num.getNumber().equals("1234")))
				.collect(Collectors.toList());

		// we want to convert the result of the stream into a String that we use some joining functionality to make the string look like an array
		String result = sWith1233And1234.stream() // [Bob, Wally]
				.map(Student::getName) // method referencing
				.collect(Collectors.joining(", ", "[", "]")); // you can use joinint to transform this data
				
		
		System.out.println(result);
		// use method referencing or lambda to print names
//		sWith1233And1234.forEach(sd4 -> System.out.println(sd4.getName()));

		// Code your Solution here

		/***************************************************************************
		 * (5) Create a List<Student> from the tmpStudents List. Call it studentList.
		 * Hint: Use Collectors.toList(). Print it to the console. Resource:
		 * https://www.geeksforgeeks.org/collectors-tolist-method-in-java-with-examples/
		 ****************************************************************************/
		TempStudent tmpStud1 = new TempStudent("Bob1", 201, new Address("12341"),
				Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

		TempStudent tmpStud2 = new TempStudent("Alice1", 202, new Address("12351"),
				Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

		List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

		// Code your Solution here, don't touch the code above

		// 1. create a list of Student objects
		List<Student> studentList =  tmpStudents.stream()
				// 2. use a stream() method to map each temp student to a Student student object
				.map(temp -> new Student(temp.name, temp.age, temp.address, temp.mobileNumbers))
				.collect(Collectors.toList()); 	// 3. return it as a list using Collectors.toList();
		
		
		System.out.println("======== 5 =====");
		// us e a forEach() method to print it out
		studentList.forEach(System.out::println);
	
		
		
		/***************************************************************************
		 * (6) Convert the List<Student> called studentList that you made in question
		 * (5) to List<String> of just their names. Call this new list "studentNames".
		 * Print it to the console.
		 ****************************************************************************/

		// instantitae the List<String> studentNames
		List<String> studentNames = studentList.stream()
				// use method referencing to replace the lambda below - think: what METHOD, from what CLASS am I referencing?
				.map(Student::getName) // map will accumulate values based on the function we pass it
				.collect(Collectors.toList()); // terminal operation
		
		// map over each value, getName() of each object
		// .map() generates a new value
		
		// use the Collector.toList() to grab all of those objects and reutrh them in the list
		
		System.out.println("============================");
		
		System.out.println(studentNames);
		
		
		
		
		// Code your Solution here

		/***************************************************************************
		 * (7) Convert List<Students> to a single String called name with just their
		 * names. Print that String to the console.
		 ****************************************************************************/

		// Code your Solution here
		String names = students.stream()
				.map(Student::getName) // returns all the name values
				.collect(Collectors.joining(", ", "[", "]")); // to convert a list to a string hint: joining -> [X, Y, Z];
		
		System.out.println("========== 7 ==========");
		System.out.println(names);

		/****************************************************************************
		 * (8) Change all the Strings within the List<String> nameList to Upper Case.
		 * Print it to the screen.
		 *****************************************************************************/
		List<String> nameList = Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");

		// Code your Solution here, don't touch the code above\
			List<String> upperCaseNames = nameList.stream()
					.map(String::toUpperCase)
					.collect(Collectors.toList());
		
			System.out.println("======== 8 ==========");
			
			upperCaseNames.forEach(System.out::println);
		

		/****************************************************************************
		 * (9) Sort List<String> namesList by natural order. Hint: Research .sorted()
		 * method
		 * https://www.geeksforgeeks.org/stream-sorted-in-java/#:~:text=Stream%20sorted()%20returns%20a,streams%2C%20no%20stability%20is%20guaranteed.
		 *****************************************************************************/
		List<String> namesList = Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");

		
		System.out.println("========== 9 ==========");
		namesList.stream()
			.sorted()
			.forEach(System.out::println);
		
		// Code your Solution here, don't touch the code above

	}

}
