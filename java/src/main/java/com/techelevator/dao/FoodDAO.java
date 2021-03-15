package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Food;

public interface FoodDAO {
	
	List<Food>findAll();
	
	 Food getFoodByName(String foodName);
	 
	 void delete(int foodId);
	 
	 int update(Food food, int foodId);

}
