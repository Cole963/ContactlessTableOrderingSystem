package com.screamscrum.testing;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.screamscrum.useradmin.entity.UserAccount;
import com.screamscrum.useradmin.entity.UserProfile;

class TestCases {

	private UserAccount ua = null;
	private UserProfile up = null;
	
	//For random String
	final String alphabet = "qwertyuiopasdfghjklzxcvbnm";
	final int N = alphabet.length();
	
	
	@Before
	void setUp() throws Exception{
		ua = new UserAccount();
		up = new UserProfile();
		
		
		
		//Random User Account generatation for adding User Account
		Random r = new Random();
		String name = "";
		String username = "";
		String password = "";
		String email = "";
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 10; j++) {
				if(i == 0) {
					name = name + String.valueOf(alphabet.charAt(r.nextInt(N)));
				}
				else if(i == 1) {
					username = username + String.valueOf(alphabet.charAt(r.nextInt(N)));
				}
				else if(i == 2) {
					password = password + String.valueOf(alphabet.charAt(r.nextInt(N)));
				}
				else {
					email = email + String.valueOf(alphabet.charAt(r.nextInt(N)));
				}
			}
		}
		email = email + "@gmail.com";
		

		
		ua.setName(name);
		ua.setUsername(username);
		ua.setPassword(password);
		ua.setUserprofile(up);
		ua.setEmail(email);
		ua.setStatus("active");
		
		// Random User Profile generation for adding User Profile
		String profile = "";
		String description = "";
		
		for (int i = 0; i < 2; i++) {
			for(int j = 0; j < 10; j++) {
				if(i == 0) {
					profile = profile + String.valueOf(alphabet.charAt(r.nextInt(N)));
				}
				else {
					description = description + String.valueOf(alphabet.charAt(r.nextInt(N)));
				}
			}
		}
		
		up.setProfile(profile);
		up.setDescription(description);
		
		
	}
	
	@After
	void tearDown() throws Exception{
		ua = null;
		up = null;
	}
	

	//Add new User Account
	@Test
	void insertUserAccountTest() throws Exception{
		setUp();
		
		up.setId(1);
		up.setProfile("User Admin");
		up.setDescription("Manage user accounts and profiles");
				
		assertTrue(ua.insertUserAccount());

	}

	//Suspend User Account
	@Test
	void updateUserAccountStatusTest() throws Exception{
		setUp();
		ua.setId(3);
		String status = ua.getStatus();
		if(status == "active") {
			ua.setStatus("suspended");
		}
		else if(status == "suspended"){
			ua.setStatus("active");
		}

		assertTrue(ua.updateUserAccountStatus());
	}
	
	//Edit User Account
	@Test
	void updateUserAccountTest() throws Exception{
		
		setUp();
		
		ua.setId(14);
		ua.setName("Manager");
		ua.setUsername("testupdateusername");
		ua.setEmail("testupdateemail");
		ua.setPassword("12345");
		ua.setStatus("active");
		
		up.setId(2);
		up.setProfile("Restaurant Manager");
		ua.setUserprofile(up);
		
		assertTrue(ua.updateUserAccount());
		
	}
	
	//View all User Accounts
	@Test
	void selectAllUserAccountsTest() throws Exception{
			
		assertTrue(UserAccount.selectAllUserAccounts() instanceof List);
		
	}
	
	//Search for User Accounts
	@Test
	void searchUserAccountsTest() throws Exception{
		
		assertTrue(UserAccount.searchUserAccounts("arbitrary") instanceof List);
	}
	
	//View all User Profiles
	@Test
	void selectAllUserProfilesTest() throws Exception{
		
		assertTrue(UserProfile.selectAllUserProfiles() instanceof List);
		
	}
	
	//Search for User Profiles
	@Test
	void searchUserProfilesTest() throws Exception{
		
		assertTrue(UserProfile.searchUserProfiles("arbitrary") instanceof List);
		
	}
	
	//Add new User Profile
	@Test
	void insertUserProfileTest() throws Exception{
		setUp();
				
		assertTrue(up.insertUserProfile());

	}
	
	//Delete User Profile
	@Test
	void deleteUserProfileTest() throws Exception{
		setUp();
		
		List<UserProfile> upList = UserProfile.selectAllUserProfiles();
		int highestID = 0;
		int id;
		for(UserProfile e : upList) {
			
			id = e.getId();
			if(id > highestID) {
				highestID = id;
			}
		}
		UserProfile up = new UserProfile();
		int size = UserProfile.selectAllUserProfiles().size();
		up.setId(highestID);
		up.deleteUserProfile();
		assertNotEquals(size, UserAccount.selectAllUserAccounts().size());
	}
	
	//Edit User Profile
	@Test
	void updateUserProfileTest() throws Exception{
		
		setUp();
		
		up.setId(2);
		up.setProfile("Restaurant Manager");
		up.setDescription("Manage menu items");
		
		assertTrue(up.updateUserProfile());
		
		
	}

}
