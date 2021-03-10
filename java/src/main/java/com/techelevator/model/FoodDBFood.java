package com.techelevator.model;

public class FoodDBFood {
 
	private String description;
	private Nutrient[] nutrients;
	
	public FoodDBFood() {
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Nutrient[] getNutrients() {
		return nutrients;
	}

	public void setNutrients(Nutrient[] nutrients) {
		this.nutrients = nutrients;
	}
	
	public Food convertToFood() {
		return null;
	}
	
	
}
