package com.techelevator.model;

public class ExerciseDBExercise {
	
	private String name;
	private int duration_min;
	private int nf_calories;
	
	public ExerciseDBExercise() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration_min() {
		return duration_min;
	}

	public void setDuration_min(int duration_min) {
		this.duration_min = duration_min;
	}

	public int getNf_calories() {
		return nf_calories;
	}

	public void setNf_calories(int nf_calories) {
		this.nf_calories = nf_calories;
	}
	
	public Exercise convertToExercise() {
		return null;	
	}

}
