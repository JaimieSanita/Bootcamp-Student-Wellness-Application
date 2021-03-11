package com.techelevator.dao;

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
	public Goals create(Goals newGoals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateGoals(Goals goals, String username) {
		String query = "UPDATE  user_goals SET date_assigned = ?, category = ?, activity = ?, times_per_week = ?, duration = ?, is_completed = ? " + 
				"FROM user_goals AS g JOIN users ON users.user_id = g.user_id  WHERE username = ?"
				;
		return jdbcTemplate.update(query, goals.getDate(), 
				goals.getCategory(), goals.getActivity(), goals.getTimesPerWeek(),
				goals.getDuration(),goals.isCompleted(), findUserIdByUsername(username));
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
		String query = "SELECT user_goals_id,  date_assigned, category, activity, times_per_week, duration, is_completed FROM user_goals "+
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
		String query = "SELECT user_goals.* FROM user_goals JOIN users ON user_goals.user_id = users.user_id WHERE users.username = ?";
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
		goals.setuserId(rs.getInt("user_id"));
		goals.setDate(rs.getDate("date_assigned"));
		goals.setCategory(rs.getString("category"));
		goals.setActivity(rs.getString("activity"));
		goals.setTimesPerWeek(rs.getInt("times_per_week"));
		goals.setDuration(rs.getInt("duration"));
		goals.setCompleted(rs.getBoolean("is_completed"));
		return goals;	
		
	}
	
}
