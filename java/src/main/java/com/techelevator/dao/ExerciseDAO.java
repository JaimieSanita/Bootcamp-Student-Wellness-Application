package com.techelevator.dao;

import java.util.List;
import com.techelevator.model.Exercise;

public interface ExerciseDAO {
	
	
	Exercise create(Exercise exercise);
	
	String updateExercise(Exercise exercise, String username);
	
	Exercise findExerciseByName(String name);
	
	int findExerciseIdByUsername(String username);
	
	Exercise getExerciseByUsername(String Username);
	
	List<Exercise>listAllExercises();

	
}
