package com.screamscrum.useradmin.entity;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import com.screamscrum.useradmin.dao.UserAccountDAO;

public class UserAccount {
	private int id;
	private String username;
	private String password;
	private String name;
	private String email;
	private String status;	
	private UserProfile userProfile;
	private UserAccountDAO userAccountDAO;
	
	public UserAccount() {
		userProfile = new UserProfile();
		userAccountDAO = new UserAccountDAO();
	}
	
	public UserAccount(int id) {
		this.id = id;
		userProfile = new UserProfile();
		userAccountDAO = new UserAccountDAO();
	}
	
	public UserAccount(String username, String password, String name, String email, String status, UserProfile userProfile) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.status = status;
		this.userProfile = new UserProfile(userProfile.getId(), userProfile.getProfile(), userProfile.getDescription());
		userAccountDAO = new UserAccountDAO();
	}

	public UserAccount(int id, String username, String password, String name, String email, String status, UserProfile userProfile) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.status = status;
		this.userProfile = new UserProfile(userProfile.getId(), userProfile.getProfile(), userProfile.getDescription());
		userAccountDAO = new UserAccountDAO();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserProfile getUserprofile() {
		return userProfile;
	}

	public void setUserprofile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	public static List<UserAccount> selectAllUserAccounts() {
		UserAccountDAO userAccountDAO = new UserAccountDAO();
		return userAccountDAO.selectAllUserAccounts();
	}
	
	public static List<UserAccount> searchUserAccounts(String input) {
		UserAccountDAO userAccountDAO = new UserAccountDAO();
		return userAccountDAO.searchUserAccounts(input);
	}
	
	public void selectUserAccount() {
		Hashtable<String, String> values = userAccountDAO.selectUserAccount(id);
		username = values.get("username");
		password = values.get("password");
		name = values.get("name");
		email = values.get("email");
		status = values.get("status");
		userProfile.setId(Integer.parseInt(values.get("userProfileFK")));
		userProfile.setProfile(values.get("profile"));
		userProfile.setDescription(values.get("description"));
	}
	
	public boolean insertUserAccount() throws SQLException {
		boolean inserted = userAccountDAO.insertUserAccount(username, password, name, email, status, userProfile);
		return inserted;
	}
	
	public boolean updateUserAccountStatus() throws SQLException {
		boolean suspended = userAccountDAO.updateUserAccountStatus(id, status);
		return suspended;
	}
	
	public boolean updateUserAccount() throws SQLException {
		boolean updated = userAccountDAO.updateUserAccount(username, password, name, email, status, userProfile, id);
		return updated;
	}
	
	public boolean usernameExists() {
		return userAccountDAO.usernameExists(username);
	}
	
	public boolean emailExists() {
		return userAccountDAO.emailExists(email);
	}
	
	public boolean login()
	{
		if(userAccountDAO.login(username, password))
		{
			String profile = userAccountDAO.getLoginProfile(username);
			userProfile.setProfile(profile);
			return true;
		}
		return false;
	}
}
