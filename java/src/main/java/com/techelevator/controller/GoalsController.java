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
import com.techelevator.dao.UserDAO;
import com.techelevator.exception.ProfileNotFoundException;
import com.techelevator.model.Goals;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin()
public class GoalsController {
	private GoalsDAO dao;
	private UserDAO uDao;

	public GoalsController(GoalsDAO dao, UserDAO uDao) {
		this.dao = dao;
		this.uDao = uDao;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "user/goals/{userGoalsId}", method = RequestMethod.PUT)
	public void updateGoals(@RequestBody Goals goals, @PathVariable int userGoalsId) throws ProfileNotFoundException {
		this.dao.updateGoals(goals, userGoalsId);
	}
	@RequestMapping(path="user/goals/{userGoalsId}", method = RequestMethod.GET)
	public Goals getGoalByUserGoalsId( @PathVariable int userGoalsId) {
		 return this.dao.getByUserGoalsId( userGoalsId);
	}  
	@RequestMapping(path = "/user/goals", method = RequestMethod.GET)
	public List<Goals> getAllGoals(Principal principal){
		String loggedIn = principal.getName();
		
		return dao.listAllGoalsByUsername(loggedIn);
		
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/user/goals", method = RequestMethod.POST)
	public Goals createGoals(Principal principal, @RequestBody Goals newGoals) throws SQLException {
		int userId = this.uDao.findIdByUsername(principal.getName());
		newGoals.setUserId(userId);
		return dao.create(newGoals);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(path = "/user/goals/{goalId}", method = RequestMethod.DELETE)
	public void delete(Principal principal, @PathVariable int goalId) {
		if (dao.userOwnsGoal(principal.getName(), goalId)) {
			this.dao.delete(goalId);
		} else {
			// throw forbidden exception
		}

	}

}
