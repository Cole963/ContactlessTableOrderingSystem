package com.screamscrum.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.screamscrum.dbconnection.DbConnection;
import com.screamscrum.manager.entity.MenuItem;

public class MenuItemDAO {
	private static final String INSERT_MENUITEM = "INSERT INTO menuitem" + " (name, price, picture) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_MENUITEM_BY_ID = "select * from menuitem where id = ?";
	private static final String SELECT_MENUITEM_BY_NAME = "select * from menuitem where name like ?";
	private static final String SELECT_ALL_MENUITEMS = "select * from menuitem";
	private static final String DELETE_MENUITEM = "delete from menuitem where id = ?;";
	private static final String UPDATE_MENUITEM = "update menuitem set name = ?, price = ?, picture = ? where id = ?;";
	private static final String UPDATE_MENUITEMWITHOUTIMAGE = "update menuitem set name = ?, price = ? where id = ?;";
	
	public void insertMenuItem(MenuItem menuItem) throws SQLException
	{
		try(Connection connection = DbConnection.init();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MENUITEM))
		{
			preparedStatement.setString(1, menuItem.getName());
			preparedStatement.setDouble(2, menuItem.getPrice());
			preparedStatement.setString(3, menuItem.getPicture());
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
	}
	
	public MenuItem selectMenuItemById(int id)
	{
		MenuItem menuItem = null;
		
		//Step 1: Establishing a Connection
		try (Connection connection = DbConnection.init();
				
			//Step 2: Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MENUITEM_BY_ID);)
		{
			preparedStatement.setInt(1, id);
			
			//Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			
			//Step 4: Process the ResultSet object.
			while (rs.next())
			{
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String picture = rs.getString("picture");
				menuItem = new MenuItem(id, name, price, picture);
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return menuItem;
	}
	
	public List<MenuItem> selectMenuItemByName(String input)
	{
		List<MenuItem> menuItem = new ArrayList<>();
		try(Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MENUITEM_BY_NAME);)
		{
			preparedStatement.setString(1, '%' + input + '%');
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String picture = rs.getString("picture");
				menuItem.add(new MenuItem(id, name, price, picture));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return menuItem;
	}
	
	public List<MenuItem> selectAllMenuItems()
	{
		List<MenuItem> menuItems = new ArrayList<>();
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MENUITEMS);)
		{
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String picture = rs.getString("picture");
				menuItems.add(new MenuItem(id, name, price, picture));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return menuItems;
	}
	
	public boolean deleteMenuItem(int id) throws SQLException
	{
		boolean rowDeleted;
		try (Connection connection = DbConnection.init();
				PreparedStatement statement = connection.prepareStatement(DELETE_MENUITEM);)
		{
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean updateMenuItem(MenuItem menuItem) throws SQLException
	{
		boolean rowUpdated;
		try (Connection connection = DbConnection.init();
				PreparedStatement statement = connection.prepareStatement(UPDATE_MENUITEM);)
		{
			statement.setString(1, menuItem.getName());
			statement.setDouble(2, menuItem.getPrice());
			statement.setString(3, menuItem.getPicture());
			statement.setInt(4, menuItem.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean updateMenuItemWithoutImage(MenuItem menuItem) throws SQLException
	{
		boolean rowUpdated;
		try (Connection connection = DbConnection.init();
				PreparedStatement statement = connection.prepareStatement(UPDATE_MENUITEMWITHOUTIMAGE);)
		{
			statement.setString(1, menuItem.getName());
			statement.setDouble(2, menuItem.getPrice());
			statement.setInt(3, menuItem.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
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
