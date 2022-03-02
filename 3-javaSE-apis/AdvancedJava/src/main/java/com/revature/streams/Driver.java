package com.revature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Driver {

	/**
	 * Stream API was introduced in Java 8
	 * It is used to process a collection of objects.
	 * 
	 * A stream is NOT a collection.  It is a sequence of object references that
	 * support various methods that can be pipelined to produce a desired result,
	 * without changing the underlying data source.
	 * 
	 * We use Streams to take input from Collections, Arrays, or IO channels
	 */
	
	public static void main(String[] args) {
		
		List<String> bingoNums = Arrays.asList(
				"D40", "D46",
				"B12", "B6",
				"G53", "G42", "g15",
				"I12", "I09"
				);
		
		
		// print only the bingo nums that start with the letter G
		bingoNums.forEach(n -> {
			if (n.startsWith("G")) {
				System.out.println(n); // there are problems because we can't change all the G-starting nums to upper case
			}
		});
		
		System.out.println("===============================");
		
		bingoNums.stream()
			.map(n -> n.toUpperCase())
			.filter(n -> n.startsWith("G"))
			.sorted()
			.forEach(System.out::println); // method referencing
//			.forEach(n -> System.out.println(n));
		
		// as we can see here it never changes the underlying data source
		System.out.println(bingoNums);
		
		// how can I save my original stream to a list?
		List<String> numsThatStartWithGOnly = bingoNums.stream()
				.map(n -> n.toUpperCase())
				.filter(n -> n.startsWith("G"))
				.sorted()
				.collect(Collectors.toList());
		
		System.out.println("This is all the bingo nums that begin with G " + numsThatStartWithGOnly);
				
		// we're seeking one value that may or may NOT exist...like A numbers
		Optional<String> aNum = bingoNums.stream() // map if a funciton to perform one operation on each element
				.map(String::toUpperCase) // e -> e.toUpperCase // how would you use method referencing to replace this?
				.filter(n -> n.startsWith("A"))
				.findFirst(); // since this stream operation may or may not return a value (in which case
							  // if it doesn't return a value, it's null)...
								
		System.out.println((aNum.isPresent()) ? aNum.get() : "Sorry, no value found");

		// highlight and press ctrl + /
		// if () {
			// print somthing
//		} else {
//			// do somehting else	
//		}
		
	
	}
	
	
	
	
	

}
