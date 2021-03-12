package com.techelevator.model;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Goals {
	private Integer userGoalsId;
	private Integer userId;
	@JsonFormat( pattern="MM/dd/yyyy")
	private LocalDate date;
	private int categoryId;
	private String activity;
	private int timesPerWeek;
	private int duration;
	private boolean isCompleted;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@JsonFormat( pattern="MM/dd/yyyy")
	public LocalDate getDate() {
		return date;
	}
	@JsonFormat( pattern="MM/dd/yyyy")
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Integer getUserGoalsId() {
		return userGoalsId;
	}
	public void setUserGoalsId(Integer userGoalsId) {
		this.userGoalsId = userGoalsId;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public int getTimesPerWeek() {
		return timesPerWeek;
	}
	public void setTimesPerWeek(int timesPerWeek) {
		this.timesPerWeek = timesPerWeek;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Goals() {
		
	}
	
	
	
}
