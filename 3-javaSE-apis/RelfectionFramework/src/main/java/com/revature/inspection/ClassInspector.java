package com.revature.inspection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Reflection is the process of inspecting and modifying behavior of a class at
 * runtime by way of methods found in the Reflection API (part of the JRE)
 */
public class ClassInspector {

	// TODO: JDK Dynamic Proxy - dynamically alterthe behavior of a class at runtime
	// - leads to performance overhead (things run slower)

	// Goal: this method is capable of accepting a class as a parameter and printing
	// every detail about it
	public static void inspectClass(Class<?> clazz) { // we need to use clazz instead of class because that's a keyword

		listPublicFields(clazz);
		listNonPublicFields(clazz);

	}

	public static void listPublicFields(Class<?> clazz) {

		System.out.println("Printing out the public fields of the class " + clazz.getSimpleName());

		// capture an array of fields that belong to the class
		Field[] fields = clazz.getFields(); // Field comes from java.lang.reflect

		if (fields.length == 0) {
			System.out.println("\n There are no public fields in " + clazz.getSimpleName());
		}

		// iterate over them and check if they're public, then print them out with their
		// type
		for (Field field : fields) {

			System.out.println("\tField name: " + field.getName());
			System.out.println("\tField type: " + field.getType());
			System.out.println("\tIs the field primitive? : " + field.getType().isPrimitive());
			System.out.println("\tModifiers bit value: " + Integer.toBinaryString(field.getModifiers()));
		}
	}

	// listpubliMethods

	// listNonPublicFields
	public static void listNonPublicFields(Class<?> clazz) {

		System.out.println("Printing out the non-public fields of the class " + clazz.getSimpleName());

		// capture an array of fields that belong to the class
		Field[] fields = clazz.getDeclaredFields(); // Field comes from java.lang.reflect

		if (fields.length == 0) {
			System.out.println("\n There are no non-public fields in " + clazz.getSimpleName());
		}

		// iterate over them and check if they're public, then print them out with their
		// type
		for (Field field : fields) {

			if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
				continue;
			}

			System.out.println("\tField name: " + field.getName());
			System.out.println("\tField type: " + field.getType());
			System.out.println("\tIs the field primitive? : " + field.getType().isPrimitive());
			System.out.println("\tModifiers bit value: " + Integer.toBinaryString(field.getModifiers()));
		}
	}
}
