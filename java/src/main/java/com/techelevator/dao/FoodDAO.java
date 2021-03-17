package com.techelevator.dao;

import java.sql.SQLException;
import java.util.List;

import com.techelevator.model.Food;

public interface FoodDAO {
	
	Food create(Food food) throws SQLException;
	Food getByUserFoodsId(int userFoodsId);

	
	 
	 void delete(int foodId);
	 
	 int update(Food food, int userFoodsId);
	boolean userOwnsFood(String username, int userFoodsId);

}
