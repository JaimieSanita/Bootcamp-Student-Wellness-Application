package com.techelevator.model;

public class Food {
	private int userFoodsId;
	private int foodId;
	private String name;	
	private int servings;
	private int userId;
	private int userMealsId;
	public int getUserFoodsId() {
		return userFoodsId;
	}
	public void setUserFoodsId(int userFoodsId) {
		this.userFoodsId = userFoodsId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserMealsId() {
		return userMealsId;
	}
	public void setUserMealsId(int userMealsId) {
		this.userMealsId = userMealsId;
	}
	public Food() {
		
	}
	
	
	
	
	
}


