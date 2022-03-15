package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.FoodRepository;
import com.revature.model.Food;

// This class DEPENDS on the repository layer

@Service // Component -> Repository, Service, Controller (sterotype annotations)
public class FoodService {
	
	// Since we've autowired an interface that we've assigned the @Repository annotation
	// Spring knows to inject an Implementation class which the service layer can use
	@Autowired
	private FoodRepository foodRepo;
	
	
	// methods to be called by the web/controller layer:
	
	// findAllFoods() returns a list of food items in the DB
	public List<Food> findAllFoods() {
		
		// we call the findAll() method from the dao (FoodRepository)
		return foodRepo.findAll();
	}
	
	// add a food, return the PK generated
	public int addFood(Food food) {
		
		Food savedFood = foodRepo.save(food);
		return savedFood.getId();
	}
	
	// delete by id
	public void deleteById(int id) {
		
		// the CrudRepository's deleteById() method has void return type
		foodRepo.deleteById(id);
	}
	
	public Food findFoodByDishName(String dishName) {
		
		// return the repository's impl class's method...
		Optional<Food> possibleFood = foodRepo.findByDishNameIgnoreCase(dishName);
		
		// IF the optional returns a food record, return the value of the food object
		// otherwise return null;
		return possibleFood.isPresent() ? possibleFood.get() : null;
		
	}

}
