package com.screamscrum.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.screamscrum.dbconnection.DbConnection;
import com.screamscrum.staff.entity.OrderItem;

public class OrderItemDAO 
{	
	//CRUD
	private static final String SELECT_ORDERITEMS_BY_ORDER_ID = "select * from orderitem where oi_orderid = ? order by oi_id;";
	private static final String SEARCH_ORDERITEMS = "select * from orderitem where oi_name like ? and oi_orderid = ? order by oi_id;";
	private static final String SELECT_ORDERITEM_BY_ID = "select * from orderitem where oi_id = ?;";
	private static final String INSERT_ORDERITEM = "INSERT INTO orderitem" + "  (oi_name, oi_unitprice, oi_quantity, oi_subtotalprice, oi_orderid) VALUES "
			+ " (?, ?, ?, ?, ?);";
	private static final String DELETE_ORDERITEM = "delete from orderitem where oi_id = ?;";
	private static final String UPDATE_ORDERITEM = "update orderitem set oi_quantity = ?, oi_subtotalprice = ? where oi_id = ?;";
	
	public List<OrderItem> selectOrderItemsByOrderId(int orderId) 
	{
		List<OrderItem> orderItems = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERITEMS_BY_ORDER_ID);) 
		{
			preparedStatement.setInt(1, orderId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int id = rs.getInt("oi_id");
				String name = rs.getString("oi_name");
				double unitPrice = rs.getDouble("oi_unitprice");
				int quantity = rs.getInt("oi_quantity");
				double subTotalPrice = rs.getDouble("oi_subtotalprice");
				orderItems.add(new OrderItem(id, name, unitPrice, quantity, subTotalPrice));
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return orderItems;
	}
	
	public List<OrderItem> searchOrderItems(String input, int orderId) 
	{	
		input = "%"+input+"%";
		List<OrderItem> orderItems = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ORDERITEMS);)
		{
			preparedStatement.setString(1, input);
			preparedStatement.setInt(2, orderId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int id = rs.getInt("oi_id");
				String name = rs.getString("oi_name");
				double unitPrice = rs.getDouble("oi_unitprice");
				int quantity = rs.getInt("oi_quantity");
				double subTotalPrice = rs.getDouble("oi_subtotalprice");
				orderItems.add(new OrderItem(id, name, unitPrice, quantity, subTotalPrice));
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return orderItems;
	}
	
	public Hashtable<String, String> selectOrderItem(int id) 
	{
		Hashtable<String, String> values = new Hashtable<String, String> ();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERITEM_BY_ID);) 
		{
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{ 
				String name = rs.getString("oi_name");
				String unitPrice = Double.toString(rs.getDouble("oi_unitprice"));
				String quantity = Integer.toString(rs.getInt("oi_quantity"));
				String subTotalPrice = Double.toString(rs.getDouble("oi_subtotalprice"));
				String orderId = Integer.toString(rs.getInt("oi_orderid"));
				values.put("name", name);
				values.put("unitPrice", unitPrice);
				values.put("quantity", quantity);
				values.put("subTotalPrice", subTotalPrice);
				values.put("orderId", orderId);
			}
		} 
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return values;
	}
	
	public boolean insertOrderItem(String name, double unitPrice, int quantity, double subTotalPrice, int orderId) throws SQLException 
	{
		boolean rowInserted;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDERITEM)) 
		{
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, unitPrice);
			preparedStatement.setInt(3, quantity);
			preparedStatement.setDouble(4, subTotalPrice);
			preparedStatement.setDouble(5, orderId);
			rowInserted = preparedStatement.executeUpdate() > 0;	
		} 
		return rowInserted;
	}
	
	public boolean deleteOrderItem(int id) throws SQLException 
	{
		boolean rowDeleted;
		try (Connection connection = DbConnection.init();
				PreparedStatement statement = connection.prepareStatement(DELETE_ORDERITEM);) 
		{
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateOrderItem(int quantity, double subTotalPrice, int id) throws SQLException 
	{
		boolean rowUpdated;
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDERITEM);) {
			preparedStatement.setInt(1, quantity);
			preparedStatement.setDouble(2, subTotalPrice);
			preparedStatement.setInt(3, id);
			rowUpdated = preparedStatement.executeUpdate() > 0;
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
