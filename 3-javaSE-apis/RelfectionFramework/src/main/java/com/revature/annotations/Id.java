package com.revature.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * We use this annotation to determine primary keys
 */

@Target(ElementType.FIELD) // this dictates that we can only apply this annotation to a field
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {

	String columnName();
	
}
