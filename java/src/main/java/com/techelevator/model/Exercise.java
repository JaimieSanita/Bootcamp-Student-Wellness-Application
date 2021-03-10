package com.techelevator.model;

public class Exercise {
	private String category;
	private String name;
	private int duration;
	private String description;
	private int caloriesBurned;
	private  String username;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCaloriesBurned() {
		return caloriesBurned;
	}
	public void setCaloriesBurned(int caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Exercise(String category, String name, int duration, String description, int caloriesBurned) {
		this.category = category;
		this.name = name;
		this.duration = duration;
		this.description = description;
		this.caloriesBurned = caloriesBurned;
	}
	public Exercise() {}
	
	
	

}
