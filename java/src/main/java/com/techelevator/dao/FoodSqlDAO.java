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
			String insertFood = "INSERT INTO food_items(food_id, food_name, number_of_servings, user_Id, user_Meals_Id)"
					+ "VALUES (?,?,?,?,?) RETURNING *";
			SqlRowSet results = jdbcTemplate.queryForRowSet(insertFood, food.getFoodId(), food.getName(),
					food.getServings(), food.getUserId(), food.getUserMealsId());
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
	public void delete(int foodId) {
		String query = "DELETE FROM food_items WHERE user_foods_id = ?";
		this.jdbcTemplate.update(query, foodId);
	}

	@Override
	public int update(Food food, int userFoodsId) {
		String query = "UPDATE food_items SET food_id = ?, food_name = ?"
				+ "number_of_servings = ?, user_id = ? user_meals_id = ? WHERE user_foods_id = ?";
		return jdbcTemplate.update(query, food.getFoodId(), food.getName(), food.getServings(),
				food.getUserId(),food.getUserMealsId(), userFoodsId);
	}
	
	private Food mapRowToFood(SqlRowSet rs) {
		Food food = new Food();
		food.setUserFoodsId(rs.getInt("user_foods_id"));
		food.setFoodId(rs.getInt("food_id"));
		food.setName(rs.getString("food_name"));
		food.setServings(rs.getInt("number_of_servings"));
		food.setUserId(rs.getInt("user_id"));
		food.setUserMealsId(rs.getInt("user_meals_id"));
		
		return food;

	}



	@Override
	public Food getByUserFoodsId(int userFoodsId) {
		Food foods = null;
		String query = "SELECT * FROM user_foods WHERE user_foods_id = ?";
		SqlRowSet results = this.jdbcTemplate.queryForRowSet(query, userFoodsId);
		if(results.next()) {
			foods = this.mapRowToFood(results);
		}return foods;
	}
	@Override
	public boolean userOwnsFood(String username, int userFoodsId) {
		String query = "SELECT count(*) FROM user_foods AS uf JOIN users AS u ON uf.user_id = u.user_id "+
						"WHERE u.username = ? AND uf.user_foods_id = ?";
		int rowCount = this.jdbcTemplate.queryForObject(query, Integer.class, username, userFoodsId);
		return rowCount ==1;
	}

}
