package com.techelevator.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ExerciseDAO;
import com.techelevator.model.Exercise;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin()
public class ExerciseController {
	private ExerciseDAO dao;

	public ExerciseController(ExerciseDAO dao) {
		this.dao = dao;
	}
	@RequestMapping(path = "/user/exercise", method = RequestMethod.GET)
	public List<Exercise> getAllExercises(Principal principal){
		String loggedIn = principal.getName();
		
			return dao.listAllExercisesByUsername(loggedIn);  
		
	}
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="/user/exercise/{username}", method = RequestMethod.POST)
	public Exercise createExercise(@RequestBody Exercise newExercise) throws SQLException {
		return dao.create(newExercise);
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "user/exercise/{exerciseId}", method = RequestMethod.PUT) 
	public void updateExercise(@RequestBody Exercise exercise, @PathVariable int exerciseId) {
		this.dao.updateExercise(exercise, exerciseId);
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(path="/user/exercise/{exerciseId}", method = RequestMethod.DELETE)
	public void delete(Principal principal, @PathVariable int exerciseId) {
		if(dao.userOwnsExercise(principal.getName(), exerciseId)) {
			this.dao.delete(exerciseId);
		}
	}
	
}
