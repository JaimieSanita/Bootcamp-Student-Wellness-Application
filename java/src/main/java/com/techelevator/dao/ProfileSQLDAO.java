package com.techelevator.dao;

import java.math.BigDecimal;
import java.sql.Date;

import com.techelevator.model.Profile;

public class ProfileSQLDAO implements ProfileDAO{

	@Override
	public boolean create(String name, String email, int age, int feet, int inches, Date birthday, BigDecimal weight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Profile getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile updateProfile(Profile profile, String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
