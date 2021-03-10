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


import com.techelevator.model.Food;
import com.techelevator.model.FoodDBFood;
import com.techelevator.model.FoodDBWrapper;
@Component
public class FoodDBApiService {
 private final RestTemplate restTemplate = new RestTemplate();
 private final Logger log = org.slf4j.LoggerFactory.getLogger(FoodDBApiService.class);
 private final String BASE_URL ="https://api.nal.usda.gov/fdc/v1/foods/search?api_key=p6zWQm7DC0izQ9cLvCyAHa5feIQqDpgiRdJ6DAVS&query=";

public FoodDBFood[] getFoodByName(String name) {
	String queryUrl = BASE_URL + "{name}";
	Map<String, String> params = new HashMap<>();
	params.put("name",""+name);
	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(List.of(MediaType.APPLICATION_JSON));
	HttpEntity input = new HttpEntity<>(headers);
	try {
		HttpEntity<FoodDBWrapper> resultEntity = restTemplate.exchange(queryUrl, HttpMethod.GET, input, FoodDBWrapper.class, params);
		FoodDBWrapper result = resultEntity.getBody();
		if(result != null && result.getFoods() != null) {
			return result.getFoods();
		}
		
	}catch (RestClientResponseException ex) {
		System.out.println(ex.getRawStatusCode() + " : " + ex.getStatusText());
	} catch (ResourceAccessException ex) {
		System.out.println(ex.getMessage());
	}
	return null;
	
}

public FoodDBApiService() {
	
}







}
