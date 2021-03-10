package com.techelevator.model;

public class Food {
	
	private String foodName;
	private int servings;
	private String mealCategory;
	private int calories;
	
	
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
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
	public Food(String foodName, int servings, String mealCategory, int calories) {
		
		this.foodName = foodName;
		this.servings = servings;
		this.mealCategory = mealCategory;
		this.calories = calories;
	}
	public Food() {}
	
	
	}
	

