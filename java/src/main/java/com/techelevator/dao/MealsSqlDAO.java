package com.techelevator.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Meals;

public class MealsSqlDAO implements MealsDAO {
	private JdbcTemplate jdbcTemplate;

	public MealsSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Meals create(Meals meals) throws SQLException {
		Meals meal = null;
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			conn.setAutoCommit(false);
			String insertMeals = "INSERT INTO meals(meal_id, meal_category, meal_name, total_calories, quick_saved_meal, manually_input, user_id)"
					+ "VALUES(?,?,?,?,?,?,?) RETURNING *";
			SqlRowSet results = jdbcTemplate.queryForRowSet(insertMeals, meals.getMealCalories(),
					meals.getMealCategory(), meals.getMealId(), meals.getMealName(), meals.getUserId());
			if (results.next()) {
				meal = this.mapRowToMeal(results);
			}
			conn.commit();
			return meal;
		} catch (Exception e) {
			if (!conn.getAutoCommit()) {
				conn.rollback();
			}
			throw e;
		} finally {
			conn.setAutoCommit(true);
		}

	}

	private Meals mapRowToMeal(SqlRowSet r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMeal(Meals meals, int mealId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Meals findMealByName(String mealName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int MealId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Meals> listAllMeals() {
		// TODO Auto-generated method stub
		return null;
	}

}
