package com.revature.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * This annotation is used to mark properties that should 
 * be foreign keys, referencing the primary key of another object.
 *
 */

@Target(ElementType.FIELD) // this dictates that we can only apply this annotation to a field
@Retention(RetentionPolicy.RUNTIME)
public @interface JoinColumn {

	String columnName();
	
//	int mappedBy(); // this would point to the property of the object whose primary key this foreign key is referring to
	
}
