package com.techelevator.dao;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Profile;
@Service
public class ProfileSQLDAO implements ProfileDAO{

	private JdbcTemplate jdbcTemplate;
	
	public ProfileSQLDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int create(Profile newProfile) {
		String insertProfile = "INSERT INTO user_profile(profile_id,first_name, last_name, age, feet, inches, current_weight) "+
								"VALUES(?,?,?,?,?,?)";
		newProfile.setId(getNextProfileId());
		return jdbcTemplate.update(insertProfile, newProfile.getFirstName(),
											newProfile.getLastName(),
											newProfile.getAge(),
											newProfile.getFeet(),
											newProfile.getInches(),
											newProfile.getWeight());
		
		
	}

	@Override
	public int getByUsername(String username) {
		
		return jdbcTemplate.queryForObject("SELECT first_name,last_name,age,feet,inches,create_date,current_weight "+
				"FROM user_profile "+
				"JOIN users "+
				"ON user_profile.profile_id = users.user_id "+
				"WHERE username = ?",  int.class, username);
	}
	@Override
    public int findIdByUsername(String username) {
        return jdbcTemplate.queryForObject("select user_id from users where username = ?", int.class, username);
    }

	
	@Override
	public int updateProfile(Profile profile, String username) {
		String query = "UPDATE user_profile SET first_name = ?, last_name = ?, age = ?, feet = ?, inches = ?, current_weight = ? "+
						"WHERE profile_id = ?";
		return jdbcTemplate.update(query, profile.getFirstName(),
												profile.getLastName(),
												profile.getAge(),
												profile.getFeet(),
												profile.getInches(),
												profile.getWeight(),
												getByUsername(username));
	}
    private Profile mapRowToProfile(SqlRowSet rs) {
    	Profile profile = new Profile();
    	profile.setFirstName(rs.getString("first_name"));
    	profile.setLastName(rs.getString("last_name"));
    	profile.setAge(rs.getInt("age"));
    	profile.setFeet(rs.getInt("feet"));
    	profile.setInches(rs.getInt("inches"));
    	profile.setCurrentDate(rs.getDate("create_date"));
    	profile.setWeight(rs.getBigDecimal("current_weight"));
    	return profile;
    		
 }
    private int getNextProfileId() {
    	SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('profile_id')");
    	if (nextIdResult.next()) {
			return nextIdResult.getInt(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}
    }
    
    

