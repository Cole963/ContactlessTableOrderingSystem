package com.screamscrum.useradmin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.screamscrum.dbconnection.DbConnection;
import com.screamscrum.useradmin.entity.UserAccount;
import com.screamscrum.useradmin.entity.UserProfile;

public class UserAccountDAO 
{	
	//CRUD
	private static final String SELECT_ALL_USERACCOUNTS = "select * from useraccount inner join userprofile on useraccount.userprofile "
			+ "= userprofile.id order by useraccount.id;";
	private static final String SEARCH_USERACCOUNTS = "select * from useraccount inner join userprofile on useraccount.userprofile "
			+ "= userprofile.id where name like ? order by useraccount.id;";
	private static final String SELECT_USERACCOUNT_BY_ID = "select * from useraccount inner join userprofile on useraccount.userprofile "
			+ "= userprofile.id where useraccount.id = ?;";
	private static final String INSERT_USERACCOUNT = "INSERT INTO useraccount" + "  (username, password, name, email, status, userprofile) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";
	private static final String UPDATE_USERACCOUNT_STATUS = "update useraccount set status = ? where id = ?;";
	private static final String UPDATE_USERACCOUNT = "update useraccount set username = ?, password = ?, name = ?, email = ?, status = ?, userprofile = ? where id = ?;";
	
	//Checks
	private static final String SELECT_USERACCOUNT_CHECK_USERNAME_EXISTS = "select 1 from useraccount where username = ?;";
	private static final String SELECT_USERACCOUNT_CHECK_EMAIL_EXISTS = "select 1 from useraccount where email = ?;";
	private static final String SELECT_USERACCOUNT_FOR_LOGIN = "select 1 from useraccount where username = ? and password = ? and status = 'active';";
	private static final String SELECT_USERACCOUNT_FOR_LOGIN_PROFILE = "select userprofile.profile from useraccount inner join userprofile on "
			+ "useraccount.userprofile = userprofile.id where username = ?;";
	
	public List<UserAccount> selectAllUserAccounts() 
	{
		List<UserAccount> userAccounts = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERACCOUNTS);) 
		{
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int id = rs.getInt(1);
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String status = rs.getString("status");
				int userProfileFK = rs.getInt("userprofile");
				String profile  = rs.getString("profile");
				String description  = rs.getString("description");
				UserProfile userProfile = new UserProfile(userProfileFK, profile, description);
				userAccounts.add(new UserAccount(id, username, password, name, email, status, userProfile));
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return userAccounts;
	}
	
	public List<UserAccount> searchUserAccounts(String input) 
	{	
		input = "%"+input+"%";
		List<UserAccount> userAccounts = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERACCOUNTS);)
		{
			preparedStatement.setString(1, input);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int id = rs.getInt(1);
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String status = rs.getString("status");
				int userProfileFK = rs.getInt("userprofile");
				String profile  = rs.getString("profile");
				String description  = rs.getString("description");
				UserProfile userProfile = new UserProfile(userProfileFK, profile, description);
				userAccounts.add(new UserAccount(id, username, password, name, email, status, userProfile));
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return userAccounts;
	}
	
	public Hashtable<String, String> selectUserAccount(int id) 
	{
		Hashtable<String, String> values = new Hashtable<String, String> ();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERACCOUNT_BY_ID);) 
		{
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{ 
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String status = rs.getString("status");
				String userProfileFK = Integer.toString(rs.getInt("userprofile"));
				String profile  = rs.getString("profile");
				String description  = rs.getString("description");
				values.put("username", username);
				values.put("password", password);
				values.put("name", name);
				values.put("email", email);
				values.put("status", status);
				values.put("userProfileFK", userProfileFK);
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
	
	public boolean insertUserAccount(String username, String password, String name, String email, String status, UserProfile userProfile) throws SQLException 
	{
		boolean rowInserted;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERACCOUNT)) 
		{
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, status);
			preparedStatement.setInt(6, userProfile.getId());
			rowInserted = preparedStatement.executeUpdate() > 0;	
		} 
		return rowInserted;
	}

	public boolean updateUserAccountStatus(int id, String status) throws SQLException 
	{
		boolean rowSuspended;
		try (Connection connection = DbConnection.init();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERACCOUNT_STATUS);) 
		{
			statement.setString(1, status);
			statement.setInt(2, id);
			rowSuspended = statement.executeUpdate() > 0;
		}
		return rowSuspended;
	}

	public boolean updateUserAccount(String username, String password, String name, String email, String status, UserProfile userprofile, int id) throws SQLException 
	{
		boolean rowUpdated;
		try (Connection connection = DbConnection.init();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERACCOUNT);) {
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, name);
			statement.setString(4, email);
			statement.setString(5, status);
			statement.setInt(6, userprofile.getId());
			statement.setInt(7, id);
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean usernameExists(String username) 
	{
		boolean usernameExists = false;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERACCOUNT_CHECK_USERNAME_EXISTS)) 
		{
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			usernameExists = rs.next();
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return usernameExists;
	}
	
	public boolean emailExists(String email) 
	{
		boolean emailExists = false;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERACCOUNT_CHECK_EMAIL_EXISTS)) 
		{
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			emailExists = rs.next();
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return emailExists;
	}
	
	public boolean login(String username, String password) 
	{
		boolean loginSuccess = false;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERACCOUNT_FOR_LOGIN)) 
		{
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			loginSuccess = rs.next();
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return loginSuccess;
	}
	
	public String getLoginProfile(String username) 
	{
		String profile = "";
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERACCOUNT_FOR_LOGIN_PROFILE);) 
		{
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) 
			{ 
				profile = rs.getString("profile");
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return profile;
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
