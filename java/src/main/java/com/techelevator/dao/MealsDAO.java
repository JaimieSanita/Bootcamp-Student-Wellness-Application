package com.techelevator.dao;

import java.sql.SQLException;
import java.util.List;

import com.techelevator.model.Meals;

public interface MealsDAO {
	
	Meals create(Meals meals) throws SQLException;
	
	int updateMeal(Meals meals, int mealId);
	
	Meals findMealByName(String mealName);
	
	void delete(int MealId);
	
	List<Meals>listAllMeals();

}
