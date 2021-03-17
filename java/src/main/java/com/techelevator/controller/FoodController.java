package com.techelevator.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.FoodDAO;
import com.techelevator.model.Exercise;
import com.techelevator.model.Food;
import com.techelevator.model.Profile;

@PreAuthorize("isAuthenticated()")
@CrossOrigin
@RestController
public class FoodController {
	private FoodDAO dao;

	public FoodController(FoodDAO dao) {
		this.dao = dao;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="/profile/food", method = RequestMethod.POST)
	public void create(@RequestBody Food newFood) throws Exception {
		this.dao.create(newFood);
		
	
	}	
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "user/food/{userFoodsId}", method = RequestMethod.PUT) 
	public void updateExercise(@RequestBody Food food, @PathVariable int userFoodsId) {
		this.dao.update(food, userFoodsId);
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(path="/user/foods/{userFoodsId}", method = RequestMethod.DELETE)
	public void delete(Principal principal, @PathVariable int userFoodsId) {
		if(dao.userOwnsFood(principal.getName(), userFoodsId)) {
			this.dao.delete(userFoodsId);
		}
	}
	@RequestMapping(path="/user/foods/{userFoodsId}", method = RequestMethod.GET)
	public Food getExerciseById(@PathVariable int userFoodsId) {
		return this.dao.getByUserFoodsId(userFoodsId);
	}
	
	
	

}
