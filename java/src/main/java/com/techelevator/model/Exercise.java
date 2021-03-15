package com.techelevator.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Exercise {
	private int userExerciseId;
	private int userId;
	private int exerciseCategoryId;
	private String exerciseName;
	@JsonFormat( pattern="MM/dd/yyyy")
	private LocalDate date;
	private int exerciseLength;
	private String exerciseDescription;
	private int caloriedBurned;
	private boolean equipmentUsed;
	
	
	@JsonFormat( pattern="MM/dd/yyyy")
	public LocalDate getDate() {
		return date;
	}
	@JsonFormat( pattern="MM/dd/yyyy")
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	public int getUserExerciseId() {
		return userExerciseId;
	}
	public void setUserExerciseId(int userExerciseId) {
		this.userExerciseId = userExerciseId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getExerciseCategoryId() {
		return exerciseCategoryId;
	}
	public void setExerciseCategoryId(int exerciseCategoryId) {
		this.exerciseCategoryId = exerciseCategoryId;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public int getExerciseLength() {
		return exerciseLength;
	}
	public void setExerciseLength(int exerciseLength) {
		this.exerciseLength = exerciseLength;
	}
	public String getExerciseDescription() {
		return exerciseDescription;
	}
	public void setExerciseDescription(String exerciseDescription) {
		this.exerciseDescription = exerciseDescription;
	}
	public boolean isEquipmentUsed() {
		return equipmentUsed;
	}
	public void setEquipmentUsed(boolean equipmentUsed) {
		this.equipmentUsed = equipmentUsed;
	}
	public int getCaloriedBurned() {
		return caloriedBurned;
	}
	public void setCaloriedBurned(int caloriedBurned) {
		this.caloriedBurned = caloriedBurned;
	}
	public Exercise() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
