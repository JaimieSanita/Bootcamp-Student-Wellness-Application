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

import com.techelevator.dao.GoalsDAO;
import com.techelevator.exception.ProfileNotFoundException;
import com.techelevator.model.Goals;
@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin()
public class GoalsController {
	private GoalsDAO dao;
	
	public GoalsController(GoalsDAO dao) {
		this.dao = dao;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "user/goals/{username}", method = RequestMethod.PUT) 
	public void updateGoals(@RequestBody Goals goals, @PathVariable String username)  throws ProfileNotFoundException{
		this.dao.updateGoals(goals, username);
	}
	
	@RequestMapping(path = "/user/goals/{username}", method = RequestMethod.GET)
	public List<Goals> getAllGoals(Principal principal, @PathVariable String username){
		String loggedIn = principal.getName();
		if(username != null && loggedIn != null && loggedIn.equalsIgnoreCase(username)) {
		return dao.listAllGoalsByUsername(username);
		
	} return new ArrayList<Goals>();// throw forbidden exception	
	}
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="/user/goals/{username}", method = RequestMethod.POST)
	public Goals createGoals(@RequestBody Goals newGoals) throws SQLException {
			return dao.create(newGoals);
		}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(path="/user/goals/{goalId}", method = RequestMethod.DELETE)
	public void delete(Principal principal,@PathVariable int goalId) {
		if(dao.userOwnsGoal(principal.getName(), goalId)){
			this.dao.delete(goalId);
		}else {
			//throw forbidden exception
		}
		
	}
	
	
	
	
	
	
	
	
	
	}


