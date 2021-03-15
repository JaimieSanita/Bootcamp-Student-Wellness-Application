package com.techelevator.dao;

import java.sql.SQLException;
import java.util.List;

import com.techelevator.model.Food;

public interface FoodDAO {
	
	Food create(Food food) throws SQLException;
	
	List<Food>findAll();
	
	 Food getFoodByName(String foodName);
	 
	 void delete(int foodId);
	 
	 int update(Food food, int foodId);

}
