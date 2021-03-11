package com.techelevator.model;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Goals {
	private int userGoalsId;
	private int userId;
	@JsonFormat(shape = JsonFormat.Shape.STRING , pattern="yyyy-MM-dd")
	private Date date;
	private int categoryId;
	private String activity;
	private int timesPerWeek;
	private int duration;
	private boolean isCompleted;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
