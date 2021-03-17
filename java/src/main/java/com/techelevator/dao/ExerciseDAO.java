package com.techelevator.dao;

import java.sql.SQLException;
import java.util.List;
import com.techelevator.model.Exercise;

public interface ExerciseDAO {
	
	
	Exercise create(Exercise exercise) throws SQLException;
	
	int updateExercise(Exercise exercise, int exerciseId);
	
	Exercise findExerciseByName(String name);
	
	void delete(int userExerciseId);
	
	List<Exercise>listAllExercises();

	List<Exercise> listAllExercisesByUsername(String username);
	
	public boolean userOwnsExercise(String username, int exerciseId);
	
	Exercise getByUserExerciseID(int userExerciseId);

	
}
