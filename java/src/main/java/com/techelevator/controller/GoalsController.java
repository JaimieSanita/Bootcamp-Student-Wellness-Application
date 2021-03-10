package com.techelevator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.GoalsDAO;
import com.techelevator.model.Goals;
@RestController
@CrossOrigin()
public class GoalsController {
	private GoalsDAO dao;
	
	public GoalsController(GoalsDAO dao) {
		this.dao = dao;
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path ="/goals/{username}", method = RequestMethod.GET)
	public Goals getByUsername(@PathVariable String username) {
		return this.dao.getByUsername(username)
;		
	}
	
}
