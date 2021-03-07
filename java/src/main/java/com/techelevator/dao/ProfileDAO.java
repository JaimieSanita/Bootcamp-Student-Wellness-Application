package com.techelevator.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.techelevator.exception.ProfileNotFoundException;
import com.techelevator.model.Profile;

public interface ProfileDAO {
	
	int create(Profile newProfile);
	
	int updateProfile(Profile profile, String username) throws ProfileNotFoundException;
	int findIdByUsername(String username);
	

	Profile getByUsername(String username);
}
