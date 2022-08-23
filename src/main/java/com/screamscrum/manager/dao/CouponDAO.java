package com.screamscrum.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.screamscrum.dbconnection.DbConnection;
import com.screamscrum.manager.entity.*;

public class CouponDAO 
{
	private static final String SELECT_ALL_COUPONS = "select * from couponcode order by id";
	private static final String SELECT_COUPONS_BY_ACTIVE = "select * from couponcode where status = 'active' order by id";
	private static final String SELECT_COUPONS_BY_EXPIRED = "select * from couponcode where status = 'expired' order by id";
	private static final String SEARCH_COUPONS = "select * from couponcode where code like ? order by id;";
	private static final String SELECT_COUPON_BY_ID = "select * from couponcode where id = ?";
	private static final String INSERT_COUPON = "INSERT INTO couponcode (code,status) VALUES (?,?)";
	private static final String DELETE_COUPON = "delete from couponcode where id = ?";
	private static final String UPDATE_COUPON = "update couponcode set code = ?, status = ? where id = ?";
	
	public List<Coupon> selectAllCoupons()
	{
		List<Coupon> coupons = new ArrayList<>();
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COUPONS);)
		{
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("id");
				String code = rs.getString("code");
				String status = rs.getString("status");
				coupons.add(new Coupon(id, code, status));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return coupons;
	}
	
	public List<Coupon> selectCouponsByActive()
	{
		List<Coupon> coupons = new ArrayList<>();
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUPONS_BY_ACTIVE);)
		{
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("id");
				String code = rs.getString("code");
				String status = rs.getString("status");
				coupons.add(new Coupon(id, code, status));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return coupons;
	}
	
	public List<Coupon> selectCouponsByExpired()
	{
		List<Coupon> coupons = new ArrayList<>();
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUPONS_BY_EXPIRED);)
		{
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("id");
				String code = rs.getString("code");
				String status = rs.getString("status");
				coupons.add(new Coupon(id, code, status));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return coupons;
	}
	
	public List<Coupon> searchCoupons(String input)
	{
		input = "%"+input+"%";
		List<Coupon> coupons = new ArrayList<>();
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_COUPONS);)
		{
			preparedStatement.setString(1, input);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("id");
				String code = rs.getString("code");
				String status = rs.getString("status");
				coupons.add(new Coupon(id, code, status));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return coupons;
	}
	
	public Coupon selectCouponById(int id)
	{
		Coupon coupon = null;
		
		//Step 1: Establishing a Connection
		try (Connection connection = DbConnection.init();
				
			//Step 2: Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUPON_BY_ID);)
		{
			preparedStatement.setInt(1, id);
			
			//Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			
			//Step 4: Process the ResultSet object.
			while (rs.next())
			{
				String code = rs.getString("code");
				String status = rs.getString("status");
				coupon = new Coupon(id, code, status);
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return coupon;
	}
	
	public void insertCoupon(Coupon coupon) throws SQLException
	{
		try(Connection connection = DbConnection.init();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COUPON))
		{
			preparedStatement.setString(1, coupon.getCode());
			preparedStatement.setString(2, coupon.getStatus());
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
	}
	
	public boolean deleteCoupon(int id) throws SQLException
	{
		boolean rowDeleted;
		try (Connection connection = DbConnection.init();
				PreparedStatement statement = connection.prepareStatement(DELETE_COUPON);)
		{
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean updateCoupon(Coupon coupon) throws SQLException
	{
		boolean rowUpdated;
		try (Connection connection = DbConnection.init();
				PreparedStatement statement = connection.prepareStatement(UPDATE_COUPON);)
		{
			statement.setString(1, coupon.getCode());
			statement.setString(2, coupon.getStatus());
			statement.setInt(3, coupon.getId());
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
