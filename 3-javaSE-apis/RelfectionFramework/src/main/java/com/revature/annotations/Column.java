package com.revature.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // this dictates that we can only apply this annotation to a field
@Retention(RetentionPolicy.RUNTIME)
public @interface Column { // technically an annotation is referred to as a marker interface

	// adding a property of an annotation
	String columnName(); // this would allow the user to use it like so @Column(columnName="first_name")
	
}

/**
 * Java annotations provide data about your code without directly affecting it.
 * 
 * Target - tells when the annotation can be used (on what type of data)
 * 
 * Retention Policy - declares when the annotation is considered, read, used.
 * 
 * -- Source: the annotation is accessible during compilation
 * 
 * -- Class: the annotation is accessible during class loading
 * 
 * -- Runtime: annotation is accessible during runtime - most used in ORM's
 **/