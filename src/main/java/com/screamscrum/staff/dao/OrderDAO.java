package com.screamscrum.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.screamscrum.dbconnection.DbConnection;
import com.screamscrum.staff.entity.Order;

public class OrderDAO 
{	
	private static final String SELECT_ALL_ORDERS = "select * from orders order by o_id;";
	private static final String SEARCH_ORDERS = "select * from orders where o_mobilenum like ? order by o_id;";
	private static final String SELECT_ORDER_BY_ID = "select * from orders where o_id = ?;";
	private static final String INSERT_ORDER = "INSERT INTO orders" + "(o_timestamp, o_mobilenum, o_totalprice, o_status) VALUES "
			+ " (?, ?, ?, ?);";
	private static final String DELETE_ORDER = "delete from orders where o_id = ?;";
	private static final String UPDATE_ORDER_STATUS = "update orders set o_status = ? where o_id = ?;";
	private static final String UPDATE_ORDER_MOBILENUM = "update orders set o_mobilenum = ? where o_id = ?;";
	private static final String UPDATE_ORDER_TOTALPRICE = "update orders set o_totalprice = ? where o_id = ?;";
	private static final String SELECT_ORDER_ID_BY_MOBILENUM_AND_TIMESTAMP = "select o_id from orders where o_timestamp = ? and o_mobilenum = ?;";
	private static final String SELECT_SUM_ORDER_ITEM_SUB_TOTAL = "select oi_subtotalprice from orderitem where oi_orderid = ?;";
	
	public List<Order> selectAllOrders() 
	{
		List<Order> orders = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS);) 
		{
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int id = rs.getInt("o_id");
				String timeStamp = rs.getString("o_timestamp");
				int mobileNum = rs.getInt("o_mobilenum");
				double totalPrice = rs.getDouble("o_totalprice");
				String status = rs.getString("o_status");
				orders.add(new Order(id, timeStamp, mobileNum, totalPrice, status));
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return orders;
	}
	
	public List<Order> searchOrders(String input) 
	{	
		input = "%"+input+"%";
		List<Order> orders = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ORDERS);)
		{
			preparedStatement.setString(1, input);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int id = rs.getInt("o_id");
				String timeStamp = rs.getString("o_timestamp");
				int mobileNum = rs.getInt("o_mobilenum");
				double totalPrice = rs.getDouble("o_totalprice");
				String status = rs.getString("o_status");
				orders.add(new Order(id, timeStamp, mobileNum, totalPrice, status));
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return orders;
	}
	
	public Hashtable<String, String> selectOrder(int id) 
	{
		Hashtable<String, String> values = new Hashtable<String, String> ();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID);) 
		{
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{ 
				String timeStamp = rs.getString("o_timestamp");
				String mobileNum = Integer.toString(rs.getInt("o_mobilenum"));
				String totalPrice = Double.toString(rs.getDouble("o_totalprice"));
				String status = rs.getString("o_status");
				values.put("timeStamp", timeStamp);
				values.put("mobileNum", mobileNum);
				values.put("totalPrice", totalPrice);
				values.put("status", status);
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return values;
	}
	
	public boolean insertOrder(String timeStamp, int mobileNum, double totalPrice, String status) throws SQLException 
	{
		boolean rowInserted;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER)) 
		{
			preparedStatement.setString(1, timeStamp);
			preparedStatement.setInt(2, mobileNum);
			preparedStatement.setDouble(3, totalPrice);
			preparedStatement.setString(4, status);
			rowInserted = preparedStatement.executeUpdate() > 0;	
		} 
		return rowInserted;
	}
	
	public boolean deleteOrder(int id) throws SQLException 
	{
		boolean rowDeleted;
		try (Connection connection = DbConnection.init();
				PreparedStatement statement = connection.prepareStatement(DELETE_ORDER);) 
		{
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateOrderStatus(String status, int id) throws SQLException 
	{
		boolean rowUpdated;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER_STATUS);) {
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, id);
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean updateMobileNum(int mobileNum, int id) throws SQLException 
	{
		boolean rowUpdated;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER_MOBILENUM);) {
			preparedStatement.setInt(1, mobileNum);
			preparedStatement.setInt(2, id);
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean updateOrderTotalPrice(double totalPrice, int id) throws SQLException 
	{
		boolean rowUpdated;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER_TOTALPRICE);) {
			preparedStatement.setDouble(1, totalPrice);
			preparedStatement.setInt(2, id);
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public int selectOrderId(String timeStamp, int mobileNum) 
	{
		int id = 0;
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_ID_BY_MOBILENUM_AND_TIMESTAMP);) 
		{
			preparedStatement.setString(1, timeStamp);
			preparedStatement.setInt(2, mobileNum);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) 
			{ 
				id = rs.getInt("o_id");
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return id;
	}
	
	public double calculateTotalPriceOfOrderItems(int id) 
	{
		double totalPrice = 0.0;
		double subTotalPrice = 0.0;
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SUM_ORDER_ITEM_SUB_TOTAL);) 
		{
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{ 
				subTotalPrice = rs.getDouble("oi_subtotalprice");
				totalPrice += subTotalPrice;
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return totalPrice;
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
