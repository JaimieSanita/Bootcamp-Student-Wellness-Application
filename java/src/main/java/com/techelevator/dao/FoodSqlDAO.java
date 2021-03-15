package com.techelevator.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Food;

@Component
public class FoodSqlDAO implements FoodDAO {

	private JdbcTemplate jdbcTemplate;

	public FoodSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Food create(Food food) throws SQLException {
		Food foods = null;
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			conn.setAutoCommit(false);
			String insertFood = "INSERT INTO food_items(food_id, calories_per_serving, number_of_servings, food_name, meal_category)"
					+ "VALUES (?,?,?,?,?) RETURNING *";
			SqlRowSet results = jdbcTemplate.queryForRowSet(insertFood, food.getCalories(), food.getFoodId(),
					food.getFoodName(), food.getMealCategory(), food.getServings());
			if (results.next()) {
				foods = this.mapRowToFood(results);
			}
			conn.commit();
			return foods;
		} catch (Exception e) {
			if (!conn.getAutoCommit()) {
				conn.rollback();
			}
			throw e;
		} finally {
			conn.setAutoCommit(true);
		}

	}

	@Override
	public Food getFoodByName(String foodName) {
		for (Food food : this.findAll()) {
			if (food.getFoodName().toLowerCase().equals(foodName.toLowerCase())) {
				return food;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int foodId) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM food_items WHERE food_id = ?";
		this.jdbcTemplate.update(query, foodId);
	}

	@Override
	public int update(Food food, int foodId) {
		String query = "UPDATE food_items SET calories_per_serving = ?, number_of_servings = ?"
				+ "food_name = ?, meal_category = ?" + "WHERE food_id = ?";
		// TODO Auto-generated method stub
		return jdbcTemplate.update(query, food.getMealCategory(), food.getFoodName(), food.getCalories(),
				food.getServings(), foodId);
	}

	@Override
	public List<Food> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	private Food mapRowToFood(SqlRowSet rs) {
		Food food = new Food();
		food.setCalories(rs.getInt("calories_per_serving"));
		food.setFoodId(rs.getInt("food_id"));
		food.setFoodName(rs.getString("food_name"));
		food.setMealCategory(rs.getString("meal_category"));
		return food;

	}

}
