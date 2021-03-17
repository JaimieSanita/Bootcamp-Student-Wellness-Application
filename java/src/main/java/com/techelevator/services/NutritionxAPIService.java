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
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.dao.CalorieDAO;
import com.techelevator.dao.ExerciseDBApiService;
import com.techelevator.model.CaloriesBurned;
import com.techelevator.model.ExerciseDBWrapper;
import com.techelevator.model.NutritionxDBNutritionx;
import com.techelevator.model.NutritionxWrapper;


@Component
public class NutritionxAPIService {
	public String AUTH_TOKEN = "";
	private final RestTemplate restTemplate = new RestTemplate();
	private String BASE_URL;

	public NutritionxAPIService(String url) {
		this.BASE_URL = url;
	}

	public CaloriesBurned getCaloriesBurned() throws CaloriesBurnedException {
		CaloriesBurned burnedCalories = null;

		try {
			burnedCalories = restTemplate
					.exchange(BASE_URL + "", HttpMethod.POST, makeAuthEntity(), CaloriesBurned.class).getBody();
		} catch (RestClientResponseException ex) {
			throw new CaloriesBurnedException(ex.getRawStatusCode() + " : " + ex.getResponseBodyAsString());
		}

		return burnedCalories;
	}

	private HttpEntity makeAuthEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(AUTH_TOKEN);
		HttpEntity entity = new HttpEntity<>(headers); // transfer will be taken in as a parameter
		return entity;
	}
	/*
	 * private final Logger log =
	 * org.slf4j.LoggerFactory.getLogger(ExerciseDBApiService.class); private final
	 * String BASE_URL = "https://trackapi.nutritionix.com/v2/natural/exercise";
	 * 
	 * public NutritionxDBNutritionx[] getCaloriesBurnedByExercise(String name) {
	 * String queryUrl = BASE_URL + "{name}"; Map<String, String> params = new
	 * HashMap<>(); params.put("name", "" + name); HttpHeaders headers = new
	 * HttpHeaders(); headers.setAccept(List.of(MediaType.APPLICATION_JSON));
	 * HttpEntity input = new HttpEntity<>(headers); try {
	 * 
	 * HttpEntity<NutritionxWrapper> resultEntity = restTemplate.exchange(queryUrl,
	 * HttpMethod.GET, input, NutritionxWrapper.class, params); NutritionxWrapper
	 * result = resultEntity.getBody(); if (result != null &&
	 * result.getCaloriesBurned() != null) { return result.getCaloriesBurned(); }
	 * 
	 * } catch (RestClientResponseException ex) {
	 * System.out.println(ex.getRawStatusCode() + " : " + ex.getStatusText()); }
	 * catch (ResourceAccessException ex) { System.out.println(ex.getMessage()); }
	 * return null; } public NutritionxAPIService() {
	 * 
	 * }
	 * 
	 * @Override public CaloriesBurned create() { // TODO Auto-generated method stub
	 * return null; }
	 */

}
