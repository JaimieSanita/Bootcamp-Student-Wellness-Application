package com.techelevator.model;

import java.sql.Date;

public class Goals {
	private int userGoalsId;
	private int userId;
	private Date date;
	private String category;
	private String activity;
	private int timesPerWeek;
	private int duration;
	private boolean isCompleted;
	public int getuserId() {
		return userId;
	}
	public void setuserId(int userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getUserGoalsId() {
		return userGoalsId;
	}
	public void setUserGoalsId(int userGoalsId) {
		this.userGoalsId = userGoalsId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
