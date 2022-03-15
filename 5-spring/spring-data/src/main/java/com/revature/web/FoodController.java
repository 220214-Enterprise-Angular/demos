package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Food;
import com.revature.service.FoodService;

/**
 * The purpose of this class is to expose
 * service functionality at different endpoints for the client
 * to interact with and perform CRUD methods on our DB
 */

// @RestController automatically infers that the return type of all method will be an HTTP reposne
// aka ResponseBody
@RestController // @Controller is a TYPE of @Component... (a.k.a Stereotype Annotation)
@RequestMapping("/food") // all functionality will be exposed at the /food endpoint 
public class FoodController {
	
	@Autowired
	private FoodService foodService; // Spring IoC container knows to inject an instance of the service class
	
	
	@GetMapping("/all") // GET request to list all food records ... http://localhost:5000/food/all
	public List<Food> findAllFoods() { // how does spring know to return it as an HTTP Response?
									   // ...Because this class is annotated with @RestController! 
		// call the service layer's findAllFoods() method...
		return foodService.findAllFoods();
	}
	
	// POST request to add ... http:localhost:5000/food/add
	@PostMapping("/add") // this method takes in a Food object in JSON
	public int addFood(@RequestBody Food food) { // https://stackoverflow.com/questions/39343340/spring-why-should-i-still-use-requestbody-when-my-class-is-already-annotated
		
		// when we take in the Food obj in the form of JSON at that endpoint in the Request Body
		// Jackson Databind (object mapper) will transform the JSON to a Java Object
		return foodService.addFood(food);
	}


}
