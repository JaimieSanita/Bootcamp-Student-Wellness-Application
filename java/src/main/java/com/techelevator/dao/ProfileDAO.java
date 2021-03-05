package com.techelevator.dao;

import java.math.BigDecimal;
import java.sql.Date;

import com.techelevator.exception.ProfileNotFoundException;
import com.techelevator.model.Profile;

public interface ProfileDAO {
	
	boolean create(String name, String email, int age, int feet, int inches, Date birthday, BigDecimal weight);
	Profile getByUsername(String username) throws ProfileNotFoundException;
	Profile updateProfile(Profile profile, String username) throws ProfileNotFoundException;
}
