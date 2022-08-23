package com.screamscrum.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.screamscrum.customer.entity.*;
import com.screamscrum.dbconnection.DbConnection;

public class CartItemDAO 
{
	private static final String SELECT_MENUITEM_BY_ID = "select * from menuitem where id = ?;";
	private static final String SELECT_MENUITEM_PRICE_BY_ID = "select price from menuitem where id = ?;";
	
	public ArrayList<CartItem> getCartProducts(ArrayList<CartItem> cartList)
	{
		ArrayList<CartItem> cartProducts = new ArrayList<CartItem>();
		
		try(Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MENUITEM_BY_ID);)
		{
			if(cartList.size()>0)
			{
				for(CartItem item: cartList)
				{
					preparedStatement.setInt(1, item.getId());
					ResultSet rs = preparedStatement.executeQuery();
					
					while(rs.next())
					{
						CartItem row = new CartItem();
						row.setId(rs.getInt("id"));
						row.setName(rs.getString("name"));
						row.setPrice(rs.getDouble("price"));
						row.setSubTotalPrice(rs.getDouble("price")* item.getQuantity());
						row.setQuantity(item.getQuantity());
						cartProducts.add(row);
					}
				}
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return cartProducts;
	}
	
	public double getTotalCartPrice(ArrayList<CartItem> cartList)
	{
		double sum = 0;
		
		try(Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MENUITEM_PRICE_BY_ID);)
		{
			if(cartList.size()>0)
			{
				for(CartItem item: cartList)
				{
					preparedStatement.setInt(1, item.getId());
					ResultSet rs = preparedStatement.executeQuery();
					
					while(rs.next())
					{
						sum += rs.getDouble("price") * item.getQuantity();
					}
				}
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return sum;
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
