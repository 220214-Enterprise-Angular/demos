package com.revature.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository // Sterotype Annotation! Repository, Controller, RestController, Service
public interface UserRepository extends JpaRepository<User, Integer> { // JpaRespoitory extends Paging&SortingRepository  extends CrudReposiotry

	// spring automatically creates .save(), update(), delete, findAll(), findById()....
	
	// Property Expressions ~ custom methods to find Users based on their properties
	Optional<User> findByUsername(String username);	
	
	List<User> findByOrderByLastName(); // returns all the users in the DB sorted by their last name
	
	// custom query
	@Query("FROM User WHERE email LIKE %:pattern")
	List<User> findByEmailContains(String pattern); // johnsmi -> John Smith's User Object based on the substring passed
												    // through ("johnsmi" returns -> johnsmith@gmail.com)
	
}
