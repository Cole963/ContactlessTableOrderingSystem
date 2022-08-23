package com.screamscrum.useradmin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.screamscrum.dbconnection.DbConnection;
import com.screamscrum.useradmin.entity.UserProfile;

public class UserProfileDAO 
{
	//CRUD
	private static final String SELECT_ALL_USERPROFILES = "select * from userprofile order by id;";
	private static final String SEARCH_USERPROFILES = "select * from userprofile where profile like ? order by id;";
	private static final String SELECT_USERPROFILE_BY_ID = "select * from userprofile where id = ?;";
	private static final String INSERT_USERPROFILE = "INSERT INTO userprofile" + "  (profile, description) VALUES "
			+ " (?, ?);";
	private static final String DELETE_USERPROFILE = "delete from userprofile where id = ?;";
	private static final String UPDATE_USERPROFILE = "update userprofile set profile = ?, description = ? where id = ?;";
	
	//Checks
	private static final String SELECT_USERPROFILE_BY_PROFILE = "select profile from userprofile where profile = ?;";
	private static final String SELECT_USERACCOUNT_BY_PROFILE_ID = "select 1 from useraccount inner join userprofile on useraccount.userprofile "
			+ "= userprofile.id where userprofile.id = ?;";
	
	public List<UserProfile> selectAllUserProfiles() 
	{
		List<UserProfile> userProfiles = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERPROFILES);) 
		{
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int id = rs.getInt("id");
				String profile = rs.getString("profile");
				String description = rs.getString("description");
				userProfiles.add(new UserProfile(id, profile, description));
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return userProfiles;
	}
	
	public List<UserProfile> searchUserProfiles(String input) 
	{	
		input = "%"+input+"%";
		List<UserProfile> userProfiles = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERPROFILES);) 
		{
			preparedStatement.setString(1, input);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int id = rs.getInt("id");
				String profile = rs.getString("profile");
				String description = rs.getString("description");
				userProfiles.add(new UserProfile(id, profile, description));
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return userProfiles;
	}
	
	public Hashtable<String, String> selectUserProfile(int id) 
	{
		Hashtable<String, String> values = new Hashtable<String, String> ();
		
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERPROFILE_BY_ID);) 
		{
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) 
			{
				String profile = rs.getString("profile");
				String description = rs.getString("description");
				values.put("profile", profile);
				values.put("description", description);
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return values;
	}
	
	public boolean insertUserProfile(String profile, String description) throws SQLException 
	{
		boolean rowInserted;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERPROFILE)) 
		{
			preparedStatement.setString(1, profile);
			preparedStatement.setString(2, description);
			rowInserted = preparedStatement.executeUpdate() > 0;	
		} 
		return rowInserted;
	}

	public boolean deleteUserProfile(int id) throws SQLException 
	{
		boolean rowDeleted;
		try (Connection connection = DbConnection.init();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERPROFILE);) 
		{
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUserProfile(String profile, String description, int id) throws SQLException 
	{
		boolean rowUpdated;
		try (Connection connection = DbConnection.init();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERPROFILE);) {
			statement.setString(1, profile);
			statement.setString(2, description);
			statement.setInt(3, id);
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean profileExists(String profile) 
	{
		boolean profileExists = false;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERPROFILE_BY_PROFILE)) 
		{
			preparedStatement.setString(1, profile);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				String profileDB = rs.getString("profile");
				profileExists = profileDB.equals(profile);
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return profileExists;
	}
	
	public boolean profileInUse(int id) 
	{
		boolean profileInUse = false;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERACCOUNT_BY_PROFILE_ID)) 
		{
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			profileInUse = rs.next();
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return profileInUse;
	}

	private void printSQLException(SQLException ex) 
	{
		for (Throwable e : ex) 
		{
			if (e instanceof SQLException) 
			{
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) 
				{
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
