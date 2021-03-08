package com.techelevator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ProfileDAO;
import com.techelevator.exception.ProfileNotFoundException;
import com.techelevator.model.Profile;

@CrossOrigin
@RestController
public class ProfileController {
	private ProfileDAO dao;

	public ProfileController(ProfileDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(path = "/profile/id/{username}", method = RequestMethod.GET)
	public int getProfileId(@PathVariable String username) {
		return dao.findIdByUsername(username);
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="/profile/create", method = RequestMethod.POST)
	public void createProfile(@RequestBody Profile newProfile) throws Exception {
		this.dao.create(newProfile);
		
	
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/profile/update/{username}", method = RequestMethod.PUT)
	public void updateProfile(@RequestBody Profile profile, String username) throws ProfileNotFoundException {
		this.dao.updateProfile(profile, username);
	}

	@RequestMapping(path = "/profile/{username}", method = RequestMethod.GET)
	public Profile getProfileFromUsername(@PathVariable String username) throws ProfileNotFoundException {
		return this.dao.getByUsername(username);
	}
}
