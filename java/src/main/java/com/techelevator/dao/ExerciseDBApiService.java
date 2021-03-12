package com.techelevator.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.ExerciseDBExercise;
import com.techelevator.model.ExerciseDBWrapper;

@Component
public class ExerciseDBApiService {
	 private final RestTemplate restTemplate = new RestTemplate();
	 private final Logger log = org.slf4j.LoggerFactory.getLogger(ExerciseDBApiService.class);
	 private final String BASE_URL = "https://trackapi.nutritionix.com/v2/natural/exercise";
	 
	 public ExerciseDBExercise[] getExerciseByName(String name) {
		 String queryUrl = BASE_URL + "{name}";
		 Map<String, String> params = new HashMap<>();
		 params.put("name", ""+name);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(List.of(MediaType.APPLICATION_JSON));
		HttpEntity input = new HttpEntity<>(headers);
		try {
			HttpEntity<ExerciseDBWrapper> resultEntity = restTemplate.exchange(queryUrl, HttpMethod.GET, input, ExerciseDBWrapper.class, params);
			ExerciseDBWrapper result = resultEntity.getBody();
			if(result != null && result.getExercises() != null) {
				return result.getExercises();
			}
			
		
	 } catch (RestClientResponseException ex) {
		 System.out.println(ex.getRawStatusCode() + " : " + ex.getStatusText());
	 } catch (ResourceAccessException ex) {
		 System.out.println(ex.getMessage());
	 }
			return null;
	 }
	
	 
	 public ExerciseDBApiService() {
		 
	 }
}
