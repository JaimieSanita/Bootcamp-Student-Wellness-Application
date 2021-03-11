package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Goals;

public interface GoalsDAO {
	Goals create(Goals newGoals);
	int updateGoals(Goals goals, String username);
	int findUserIdByUsername(String username);
	Goals getByUsername(String Username);
	List<Goals> listAllGoalsByUsername(String username);

}
