package com.revature.data;

import org.springframework.stereotype.Repository;

/**
 * The Spring @Repository annotation is a specialization of the @Component
 * annotation which indicates that an annotated class is a �Repository�, which
 * can be used as a mechanism for encapsulating storage, retrieval, and search
 * behavior which emulates a collection of objects.
 */

@Repository // Component -> Repository is a Stereotype Annotation which describes how this componenet is used 
public class Dao1 {

		public String retrieveSomething() {
			
			return "Dao1";
		}
	
}
