package com.revature.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotations in Java are type of a Marker Interface
 * 
 * Annotations start with an @
 * Annotations do not change the ACTION of a compiled program
 * Annotations are used to associate metadata about the program elements (constructors, fields, methods)
 * Annotations can change the way a program is treated by the compiler
 */
@Target(ElementType.TYPE) // we use this on a class which is also referred to as a CLASS
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {

	String tableName();
	
}
