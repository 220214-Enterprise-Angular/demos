package com.revature.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDriver {
	
	public static void main(String[] args) {
		
		Map<String, String> languages = new HashMap<String, String>();
		
		// HashMap allows storing at most 1 null key
		// TreeMaps DO NOT allows null keys, but do allow null values
		// LinkedHashMap allows you to maintian the order of elements inserted into it and 
		// is exactly like HashMap

		// build a programming language dictionary
		// use the .put() method 
		languages.put("Java", "a high-level compiled OO, platform independent language");
		languages.put("Python", "an interpreted OOP language");
		languages.put("JavaScript", "interpreted, multi-paradigm language that runs in the browser or nodeJS");
		
		// no duplicate keys, duplicate values ok
		
		// retrieve a value from a map
		System.out.println(languages.get("Java")); // O(1) retrieval time - ocnstant time complexity
		
		String garbage = languages.get("JavaScript") + "ABCDEFGHIJKLMNOP";
		System.out.println(garbage);
		
		// you an replace the previous value of the hashmap like so
		languages.put("JavaScript", garbage); // the hashmap would replace the previous value with the new value
		
		// iterate over the keyset 
		
		for (String key : languages.keySet()) {
			
			System.out.println(key);
		}
		
		for (String values : languages.values()) {
			
			System.out.println(values);
		}
		
		
		// how to iterate over the entire entry set?
		for (Map.Entry<String, String> entry : languages.entrySet()) {
			
			System.out.println(entry);
			System.out.println("=====");
			
		}
		
		languages.put(null, "unspecified value");
		
		Map<Long, Animal> zooDb = new HashMap<>();
		
		zooDb.put(927347L, new Animal("Penguin", 12));
	}
	

}
