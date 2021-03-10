package com.techelevator.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.FoodDBApiService;

@CrossOrigin()
@RequestMapping()
@RestController
public class FoodDBController {
	private FoodDBApiService api;
	
	public FoodDBController(FoodDBApiService api) {
		this.api = api;
	}

}
