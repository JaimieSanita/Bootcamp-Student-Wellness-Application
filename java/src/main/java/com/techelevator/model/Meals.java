package com.techelevator.model;

public class Meals {
	
	private String foodName;
	private int servings;
	private String mealCategory;
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getServings() {
		return servings;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public String getMealCategory() {
		return mealCategory;
	}
	public void setMealCategory(String mealCategory) {
		this.mealCategory = mealCategory;
	}
	public Meals(String foodName, int servings, String mealCategory) {
		
		this.foodName = foodName;
		this.servings = servings;
		this.mealCategory = mealCategory;
	}
	public Meals() {}
	
	
}
