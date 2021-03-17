package com.techelevator.model;

public class Meals {
	private int mealId;
	private String mealCategory;
	private String mealName;
	private int mealCalories;
	private int userId;
	private boolean quickSavedMeal;
	private boolean manuallyInput;
	public int getMealId() {
		return mealId;
	}
	public void setMealId(int mealId) {
		this.mealId = mealId;
	}
	public String getMealCategory() {
		return mealCategory;
	}
	public void setMealCategory(String mealCategory) {
		this.mealCategory = mealCategory;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public int getMealCalories() {
		return mealCalories;
	}
	public void setMealCalories(int mealCalories) {
		this.mealCalories = mealCalories;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isQuickSavedMeal() {
		return quickSavedMeal;
	}
	public void setQuickSavedMeal(boolean quickSavedMeal) {
		this.quickSavedMeal = quickSavedMeal;
	}
	public boolean isManuallyInput() {
		return manuallyInput;
	}
	public void setManuallyInput(boolean manuallyInput) {
		this.manuallyInput = manuallyInput;
	}
	

}
