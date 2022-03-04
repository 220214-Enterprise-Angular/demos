package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotations.Column;
import com.revature.annotations.Id;

public class PrimaryKeyField {
	
	private Field field; // from java.lang.reflect
	
	// constructor to build an object that represents data about the field that has been annotated with @Id
	public PrimaryKeyField(Field field) {
		
		// check if it has the annotation we're looking for 
		if (field.getAnnotation(Id.class) == null) { // if it's NOT equal to @Column...
			throw new IllegalStateException("Cannot create ColumnField object! Provided field " + getName() + 
					" is not Annotated with @Id");
		}
		
		this.field = field;
	}
	
	public String getName() {
		return field.getName();
	}
	
	// return the TYPE of the field that's annotated
	public Class<?> getType() {
		return field.getType(); // think about how we could this to our advantage when we (as the ORM framework developers
							    // are crafting a way in which we can  set up a way to determine the RDBMS type for the column
	}

	// getColumnName() --> extract the column name that the user sets for that field
	public String getColumnName() {
		return field.getAnnotation(Id.class).columnName(); // extract the columnName() property that the user sets
	}

}
