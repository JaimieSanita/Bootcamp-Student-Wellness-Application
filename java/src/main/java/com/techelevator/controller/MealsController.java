package com.techelevator.controller;

import java.security.Principal;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.MealsDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.exception.ProfileNotFoundException;
import com.techelevator.model.Goals;
import com.techelevator.model.Meals;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin()
public class MealsController {

	private MealsDAO dao;
	private UserDAO uDao;
	
	public MealsController(MealsDAO dao, UserDAO uDAO) {
		this.dao = dao;
		this.uDao = uDAO;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "user/meals/{mealId}", method = RequestMethod.PUT)
	public void updateMeal(@RequestBody Meals meals, @PathVariable int mealId) throws ProfileNotFoundException {
		this.dao.updateMeal(meals, mealId);
	}
	 
	
	@RequestMapping(path="user/meals/{mealId}", method = RequestMethod.GET)
	public Meals getMealById( @PathVariable int mealId) {
		 return this.dao.getMealById(mealId);
	}  
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/user/meals", method = RequestMethod.POST)
	public Meals createMeal(Principal principal, @RequestBody Meals newMeals) throws SQLException {
		int userId = this.uDao.findIdByUsername(principal.getName());
		newMeals.setUserId(userId);
		return dao.create(newMeals);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(path = "/user/goals/{goalId}", method = RequestMethod.DELETE)
	public void delete(Principal principal, @PathVariable int mealId) {
		if (dao.userOwnsMeal(principal.getName(), mealId)) {
			this.dao.delete(mealId);
		} else {
			// throw forbidden exception
		}

	}
}
