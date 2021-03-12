package com.techelevator.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Goals;
@Component
public class GoalsSQLDAO implements GoalsDAO{
	private JdbcTemplate jdbcTemplate;
	
	public GoalsSQLDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Goals create(Goals newGoals) throws SQLException {
		Goals goals = null;
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			conn.setAutoCommit(false);
			String insertGoals = "INSERT INTO user_goals (user_id, date_assigned, category_id, activity, times_per_week, duration, is_completed) "+
			"VALUES (?,?,?,?,?,?,?) RETURNING *";
			SqlRowSet results = jdbcTemplate.queryForRowSet(insertGoals, newGoals.getUserId(), newGoals.getDate(), newGoals.getCategoryId(), newGoals.getActivity(),
															newGoals.getTimesPerWeek(), newGoals.getDuration(), newGoals.isCompleted());
			if(results.next()) {
				goals= this.mapRowToGoals(results);
			}
			conn.commit();
			return goals;			
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
	public int updateGoals(Goals goals, int userGoalsId) {
		String query = "UPDATE  user_goals SET date_assigned = ?, category_id = ?, activity = ?, times_per_week = ?, duration = ?, is_completed = ? " + 
				" WHERE user_goals_id = ?"
				;
		return jdbcTemplate.update(query, goals.getDate(), 
				goals.getCategoryId(), goals.getActivity(), goals.getTimesPerWeek(),
				goals.getDuration(),goals.isCompleted(), userGoalsId);
	}

	@Override
	public int findUserIdByUsername(String username) {
		return jdbcTemplate.queryForObject("SELECT user_goals_id FROM user_goals "+
				"JOIN users ON users.user_id = user_goals.user_id  "+
				"WHERE username =?", int.class, username);
	}

	@Override
	public Goals getByUsername(String username) {
		Goals goals = null;
		String query = "SELECT user_goals_id,  date_assigned, category_id, activity, times_per_week, duration, is_completed FROM user_goals "+
				"JOIN users ON users.user_id = user_goals.user_id  "+
				"WHERE username =?";
		SqlRowSet results = this.jdbcTemplate.queryForRowSet(query, username);
		if(results.next()) {
			goals = this.mapRowToGoals(results);
		}return goals;
	}

	@Override
	public List<Goals> listAllGoalsByUsername(String username) {
		List<Goals> goals = new ArrayList<>();
		String query = "";
		SqlRowSet results = this.jdbcTemplate.queryForRowSet(query, username);
		while(results.next()) {
			Goals resultGoals = this.mapRowToGoals(results);
			goals.add(resultGoals);
		}
		return goals;
	}
	private Goals mapRowToGoals(SqlRowSet rs) {
		Goals goals = new Goals();
		goals.setUserGoalsId(rs.getInt("user_goals_id"));
		goals.setUserId(rs.getInt("user_id"));
		goals.setDate(rs.getDate("date_assigned"));
		goals.setCategoryId(rs.getInt("category_id"));
		goals.setActivity(rs.getString("activity"));
		goals.setTimesPerWeek(rs.getInt("times_per_week"));
		goals.setDuration(rs.getInt("duration"));
		goals.setCompleted(rs.getBoolean("is_completed"));
		return goals;	
		
	}
	

	@Override
	public void delete(int userGoalsId) {
		String query = "DELETE FROM user_goals WHERE user_goals_id = ?";
		this.jdbcTemplate.update(query, userGoalsId);
		
	}

	@Override
	public boolean userOwnsGoal(String username, int goalId) {
		String query = "SELECT count(*) FROM user_goals AS ug JOIN users AS u ON ug.user_id = u.user_id "+
						" WHERE u.username = ? AND ug.user_goals_id = ?";
		int rowCount = this.jdbcTemplate.queryForObject(query, Integer.class, username,goalId);
		return rowCount ==1;
	}
	
}
