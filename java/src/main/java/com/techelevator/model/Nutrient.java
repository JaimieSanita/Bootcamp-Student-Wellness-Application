package com.techelevator.model;

import java.math.BigDecimal;

public class Nutrient {
	private String nutrientName;
	private BigDecimal value;
	public String getNutrientName() {
		return nutrientName;
	}
	public void setNutrientName(String nutrientName) {
		this.nutrientName = nutrientName;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public Nutrient () {
		
	}
	
	

}
