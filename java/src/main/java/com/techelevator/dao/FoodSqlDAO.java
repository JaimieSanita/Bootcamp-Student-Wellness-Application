package com.techelevator.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.model.Food;

@Component
public class FoodSqlDAO implements FoodDAO {


		private JdbcTemplate jdbcTemplate;

		public FoodSqlDAO(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}

		
		@Override
		public Food getFoodByName(String foodName) {
			for(Food food : this.findAll()) {
				if(food.getFoodName().toLowerCase().equals(foodName.toLowerCase())) {
					return food;
				}
			}
			// TODO Auto-generated method stub
			return null;
		}

		public void delete(int foodId) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int update(Food food, int foodId) {
			String query = "UPDATE food_items SET calories_per_serving = ?, number_of_servings = ?"
					+ "food_name = ?, meal_category = ?" + "WHERE food_id = ?";
			// TODO Auto-generated method stub
			return jdbcTemplate.update(query, food.getFoodName(), food.getCalories(), food.getServings(), foodId);
		}


		@Override
		public List<Food> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		

	}


