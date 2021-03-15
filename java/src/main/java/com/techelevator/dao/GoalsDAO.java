package com.techelevator.dao;

import java.sql.SQLException;
import java.util.List;

import com.techelevator.model.Goals;

public interface GoalsDAO {
	Goals create(Goals newGoals) throws SQLException;
	int updateGoals(Goals goals, int userGoalsId);
	int findUserIdByUsername(String username);
	Goals getByUserGoalsId(int userGoalsId);
	List<Goals> listAllGoalsByUsername(String username);
	void delete(int userGoalsId);
	boolean userOwnsGoal(String username, int goalId);
	

}
