package com.techelevator.dao;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findGoalSetterIdByUsername(String username) {
		return jdbcTemplate.queryForObject("SELECT goal_id, goal_setter, date_assigned, category, activity, times_per_week, duration, is_completed FROM goals "+
				"JOIN user_profile ON goals.goal_setter = user_profile.profile_id JOIN users ON users.user_id = user_profile.profile_id "+
				"WHERE username =?", int.class, username);
	}

	@Override
	public Goals getByUsername(String username) {
		Goals goals = null;
		String query = "SELECT goal_id, goal_setter, date_assigned, category, activity, times_per_week, duration, is_completed FROM goals "+
				"JOIN user_profile ON goals.goal_setter = user_profile.profile_id JOIN users ON users.user_id = user_profile.profile_id "+
				"WHERE username =?";
		SqlRowSet results = this.jdbcTemplate.queryForRowSet(query, username);
		if(results.next()) {
			goals = this.mapRowToGoals(results);
		}return goals;
	}

	@Override
	public List<Goals> listAllGoals() {
		// TODO Auto-generated method stub
		return null;
	}
	private Goals mapRowToGoals(SqlRowSet rs) {
		Goals goals = new Goals();
		goals.setGoalId(rs.getInt("goal_id"));
		goals.setGoalSetterId(rs.getInt("goal_setter"));
		goals.setDate(rs.getString("date_assigned"));
		goals.setCategory(rs.getString("category"));
		goals.setActivity(rs.getString("activity"));
		goals.setTimesPerWeek(rs.getInt("times_per_week"));
		goals.setDuration(rs.getInt("duration"));
		goals.setCompleted(rs.getBoolean("is_completed"));
		return goals;	
		
	}
	
}
