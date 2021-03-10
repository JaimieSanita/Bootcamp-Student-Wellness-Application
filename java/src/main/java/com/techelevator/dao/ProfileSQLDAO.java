package com.techelevator.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.techelevator.model.Profile;

@Component
public class ProfileSQLDAO implements ProfileDAO {

	private JdbcTemplate jdbcTemplate;

	public ProfileSQLDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Profile create(Profile newProfile) throws Exception {
		Profile profile = null;
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try{
			conn.setAutoCommit(false);
		String insertProfile = "INSERT INTO user_profile (user_id, first_name, last_name, email, age, feet, inches, current_weight) "
				+ "VALUES(?,?,?,?,?,?,?,?) RETURNING *";
		SqlRowSet results= jdbcTemplate.queryForRowSet(insertProfile, newProfile.getUserId(), newProfile.getFirstName(), newProfile.getLastName(), newProfile.getEmail(),
				newProfile.getAge(), newProfile.getFeet(), newProfile.getInches(), newProfile.getWeight());
		if(results.next()) {
			profile = this.mapRowToProfile(results);
		}
		
			conn.commit();
			return profile;
		}
	catch(Exception e) {
		if(!conn.getAutoCommit()) {
			conn.rollback();
		}
		throw e;
	}finally {
		conn.setAutoCommit(true);
	}
	}

	@Override
	public Profile getByUsername(String username) {
		Profile profile = null;
		
		String query = "SELECT profile_id, first_name, last_name, email, age, feet, inches, current_weight " + "FROM user_profile "
			+ "JOIN users " + "ON user_profile.user_id = users.user_id " + "WHERE username = ?";
		SqlRowSet results = this.jdbcTemplate.queryForRowSet(query, username);
		if(results.next()) {
			profile = this.mapRowToProfile(results);
		} return profile;
	}

	@Override
	public int findIdByUsername(String username) {
		return jdbcTemplate.queryForObject("select user_id from users where username = ?", int.class, username);
	}

	@Override
	public int updateProfile(Profile profile, String username) {
		String query = "UPDATE user_profile SET first_name = ?, last_name = ?, email = ?, age = ?, feet = ?, inches = ?, current_weight = ? "
				+ "WHERE user_id = ?";
		return jdbcTemplate.update(query, profile.getFirstName(), profile.getLastName(), profile.getEmail(), profile.getAge(),
				profile.getFeet(), profile.getInches(), profile.getWeight(), findIdByUsername(username));
	}

	private Profile mapRowToProfile(SqlRowSet rs) {
		Profile profile = new Profile();
		profile.setId(rs.getInt("profile_id"));
		profile.setFirstName(rs.getString("first_name"));
		profile.setLastName(rs.getString("last_name"));
		profile.setEmail(rs.getString("email"));
		profile.setAge(rs.getInt("age"));
		profile.setFeet(rs.getInt("feet"));
		profile.setInches(rs.getInt("inches"));
		profile.setWeight(rs.getBigDecimal("current_weight"));
		return profile;

	}

	private int getNextProfileId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('profile_id')");
		if (nextIdResult.next()) {
			return nextIdResult.getInt(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new profile");
		}
	}

}
