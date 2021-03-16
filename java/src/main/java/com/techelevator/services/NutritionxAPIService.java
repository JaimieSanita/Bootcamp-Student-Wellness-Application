package com.techelevator.services;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.dao.CalorieDAO;
import com.techelevator.dao.ExerciseDBApiService;

@Component
public class NutritionxAPIService implements CalorieDAO {
	
	private final RestTemplate restTemplate = new RestTemplate();
	private final Logger log = org.slf4j.LoggerFactory.getLogger(ExerciseDBApiService.class);
	 private final String BASE_URL = "https://trackapi.nutritionix.com/v2/natural/exercise";
	 
	 public Nutr
}
