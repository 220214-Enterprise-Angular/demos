package com.revature.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Food;

/**
 * This will extend JpaRepository (which comes from Spring Data)
 * and automatically creates the Impl class.
 * 
 * Typically the Impl class provides the implementation for 
 * all CRUD methods on a *Food* object
 */

// We're declaring this interface as a TYPE of Component -- a Spring Bean
// this is a vital element to our application
// By JpaRepository, Spring will create an implementation class of this Interface
// Since we specified JpaRespository<Food, Integer>, it know that the PK data type 
// is Integer, and the type of object it operates on is Food.

// this is called a Stereotype Annotation - it's a special TYPE of component
public interface FoodRepository extends JpaRepository<Food, Integer> { // <Object, PK data type>
// Spring Data automatically generates the DAO Impl class of this interface and all crud methods
	
	
	// Who depends on the Dao Implementation class? The Service layer!
	// Spring will automatically generate the implementation class of this interface
	// WHEN we @Autowire this interface as dependency of another class like the Servicelayer
	// Spring's IoC Container will inject that impl class as a dependency
	
	// all the.save(), .delete() .update() methods are all generated automatically...
	
	// property expressions - complex queries
	// Spring can automatically infer the type query to be generated when you're looking 
	// for the Object record based on 1 of its properties
	Food findByDishName(String dishName); // SELECT * FROM food WHERE dishName = ?
	
	List<Food> findByOrderByDishName(); // delete the parameter, returns all food, ordered by dish name
	
	Optional<Food> findByDishNameIgnoreCase(String dishName);
	
	// create a custom query...
	@Query(value="FROM Food WHERE dishName like %:substring") // %: serves as placeholder for param
	Optional<Food> findByDishNameContains(String substring);
	
	/**
	 *  Property Expressions in Spring (look in Spring documentation about this)
	 *  
	 *  Spring Data JPA will examine all the properties of the class that corresponds
	 *  to this repository and INFER SQL STATEMENTS based on the direct properties of the class.
	 * 
	 */
}













