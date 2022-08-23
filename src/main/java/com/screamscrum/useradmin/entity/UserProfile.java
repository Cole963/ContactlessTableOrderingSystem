package com.screamscrum.useradmin.entity;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import com.screamscrum.useradmin.dao.UserProfileDAO;

public class UserProfile {
	private int id;
	private String profile;
	private String description;
	private UserProfileDAO userProfileDAO;
	
	public UserProfile() {
		userProfileDAO = new UserProfileDAO();
	}
	
	public UserProfile(int id) {
		this.id = id;
		userProfileDAO = new UserProfileDAO();
	}
	
	public UserProfile(String profile, String description) {
		this.profile = profile;
		this.description = description;
		userProfileDAO = new UserProfileDAO();
	}

	public UserProfile(int id, String profile, String description) {
		this.id = id;
		this.profile = profile;
		this.description = description;
		userProfileDAO = new UserProfileDAO();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static List<UserProfile> selectAllUserProfiles() {
		UserProfileDAO userProfileDAO = new UserProfileDAO();
		return userProfileDAO.selectAllUserProfiles();
	}
	
	public static List<UserProfile> searchUserProfiles(String input) {
		UserProfileDAO userProfileDAO = new UserProfileDAO();
		return userProfileDAO.searchUserProfiles(input);
	}
	
	public void selectUserProfile() {
		Hashtable<String, String> values = userProfileDAO.selectUserProfile(id);
		profile = values.get("profile");
		description = values.get("description");
	}
	
	public boolean insertUserProfile() throws SQLException {
		boolean inserted = userProfileDAO.insertUserProfile(profile, description);
		return inserted;
	}
	
	public boolean deleteUserProfile() throws SQLException {
		boolean deleted = userProfileDAO.deleteUserProfile(id);
		return deleted;
	}
	
	public boolean updateUserProfile() throws SQLException {
		boolean updated = userProfileDAO.updateUserProfile(profile, description, id);
		return updated;
	}
	
	public boolean profileExists() {
		return userProfileDAO.profileExists(profile);
	}
	
	public boolean profileInUse() {
		return userProfileDAO.profileInUse(id);
	}
}
