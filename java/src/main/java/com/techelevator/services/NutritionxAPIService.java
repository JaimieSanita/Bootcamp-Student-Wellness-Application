package com.techelevator.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.dao.CalorieDAO;
import com.techelevator.dao.ExerciseDBApiService;

@Component
public class NutritionxAPIService implements CalorieDAO {
//	 private final RestTemplate restTemplate = new RestTemplate();
//	 private final Logger log = org.slf4j.LoggerFactory.getLogger(ExerciseDBApiService.class);
//	 private final String BASE_URL = "https://trackapi.nutritionix.com/v2/natural/exercise";
//	 
//	 //create NutritionxDB class
//	 public NutritionxDB[] getCaloriesBurnedByExercise(String name) {
//		 String queryUrl = BASE_URL + "{name}";
//		 Map<String, String> params = new HashMap<>();
//		 params.put("name", ""+name);
//		 HttpHeaders headers = new HttpHeaders();
//		 headers.setAccept(List.of(MediaType.APPLICATION_JSON));
//		HttpEntity input = new HttpEntity<>(headers);
//		try {
//			//create NutritionxWrapper class
//			HttpEntity<NutritionxWrapper> resultEntity = restTemplate(queryUrl, HttpMethod.GET, input, NutritionxWrapper.class, params);
//		}
//	 }
}
