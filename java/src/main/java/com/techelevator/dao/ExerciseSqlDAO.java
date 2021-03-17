package com.techelevator.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Exercise;
@Component
public class ExerciseSqlDAO implements ExerciseDAO {
	private JdbcTemplate jdbcTemplate;

	public ExerciseSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	@Override
	public Exercise create(Exercise exercise) throws SQLException {
		Exercise exercises = null;
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			conn.setAutoCommit(false);
			String insertExercises = "INSERT INTO user_exercises(user_id, exercise_category_id, exercise_name, date_assigned, exercise_length, exercise_description, calories_burn, equipment) "+
			"VALUES(?,?,?,?,?,?,?,?) RETURNING user_exercise_id";
			Integer exerciseId = jdbcTemplate.queryForObject(insertExercises, Integer.class, exercise.getUserId(), exercise.getExerciseCategoryId(),exercise.getExerciseName(),exercise.getDate(),
															exercise.getExerciseLength(), exercise.getExerciseDescription(), exercise.getCaloriesBurn(), exercise.isEquipmentUsed());
			exercises = this.getByUserExerciseID(exerciseId);
			
			conn.commit();
			return exercises;			
		}
		catch(Exception e) {
			if(!conn.getAutoCommit()) {
				conn.rollback();
			}
			throw e;
		}finally {
			conn.setAutoCommit(true);
		}
		
		
	}

	@Override
	public int updateExercise(Exercise exercise, int exerciseId) {
		String query = "UPDATE user_exercises SET exercise_category_id =?, exercise_name = ?, date_assigned=?,exercise_description = ?, calories_burn = ?, equipment = ? "+
				"WHERE user_exercise_id = ?";
		return jdbcTemplate.update(query, exercise.getExerciseCategoryId(), exercise.getExerciseName(), exercise.getDate(),exercise.getExerciseDescription(), 
				exercise.getCaloriesBurn(), exercise.isEquipmentUsed(), exerciseId);
	}

	@Override
	public Exercise findExerciseByName(String name) {
		// TODO Auto-generated method stub
		for (Exercise exercise : this.listAllExercises()) {
			if (exercise.getExerciseName().toLowerCase().equals(name.toLowerCase())) {
				return exercise;
			}
		}
		return null;
	}

	
	@Override
	public List<Exercise> listAllExercisesByUsername(String username) {
		List<Exercise> exercises = new ArrayList<>();
		String query = "SELECT user_exercises.*, exercise.exercise_category FROM user_exercises  " 
				+ "JOIN users ON user_exercises.user_id = users.user_id " 
				+ "JOIN exercise ON exercise.exercise_id = user_exercises.exercise_category_id " 
				+ " WHERE users.username=?";
		SqlRowSet results = this.jdbcTemplate.queryForRowSet(query, username);
		while(results.next()) {
			Exercise resultExercises = this.mapRowToExercise(results);
			exercises.add(resultExercises);
		}
		return exercises;
	}

	private Exercise mapRowToExercise(SqlRowSet rs) {
		Exercise exercise = new Exercise();
		exercise.setUserExerciseId(rs.getInt("user_exercise_id"));
		exercise.setUserId(rs.getInt("user_id"));
		exercise.setExerciseCategoryId(rs.getInt("exercise_category_id"));
		exercise.setExerciseCategory(rs.getString("exercise_category"));
		exercise.setExerciseName(rs.getString("exercise_name"));
		exercise.setDate(rs.getDate("date_assigned").toLocalDate());
		exercise.setExerciseLength(rs.getInt("exercise_length"));
		exercise.setExerciseDescription(rs.getString("exercise_description"));
		exercise.setCaloriesBurn(rs.getInt("calories_burn"));
		exercise.setEquipmentUsed(rs.getBoolean("equipment"));
		return exercise;

	}

	@Override
	public List<Exercise> listAllExercises() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void delete(int userExerciseId) {
		String query = "DELETE FROM user_exercises WHERE user_exercise_id =?";
		this.jdbcTemplate.update(query, userExerciseId);
		
	}


	@Override
	public boolean userOwnsExercise(String username, int exerciseId) {
		String query = "SELECT count(*) FROM user_exercises AS ue JOIN users AS u ON ue.user_id = u.user_id "+
						"WHERE u.username = ? AND ue.user_exercise_id = ?";
		int rowCount = this.jdbcTemplate.queryForObject(query, Integer.class, username, exerciseId);
		return rowCount ==1;
	}


	@Override
	public Exercise getByUserExerciseID(int userExerciseId) {
		Exercise exercise = null;
		String query = "SELECT ue.*, exercise.exercise_category FROM user_exercises AS ue " + 
				"Join users on users.user_id = ue.user_id " + 
				"JOIN exercise ON exercise.exercise_id = ue.exercise_category_id " + 
				"WHERE user_exercise_id = ?";
		SqlRowSet results = this.jdbcTemplate.queryForRowSet(query, userExerciseId);
		if(results.next()) {
			exercise = this.mapRowToExercise(results);
		}
		
		return exercise;
	}

}
