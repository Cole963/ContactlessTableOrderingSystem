package com.screamscrum.owner.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.screamscrum.dbconnection.DbConnection;
import com.screamscrum.manager.entity.MenuItem;
import com.screamscrum.owner.entity.OwnerReport;

public class OwnerDAO {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private static final String SELECT_MENU_ITEMS_BY_QUANTITY = "SELECT DISTINCT oi_name AS name, SUM(oi_quantity) AS totalQuantity , DATE(o_timestamp) as date , orderitem.oi_orderid AS id from orderitem INNER JOIN orders ON orderitem.oi_orderid = orders.o_id  WHERE o_status = 'completed' GROUP BY oi_name ORDER BY SUM(oi_quantity) DESC;";
	private static final String SELECT_CUSTOMER_AVG_SPEND = "SELECT DISTINCT DATE(o_timestamp) AS date, COUNT(o_mobilenum) AS noOfDistMobileNum , AVG(o_totalprice) AS avgSpend , o_id AS id from orders WHERE o_status = 'completed';";
	private static final String SELECT_CUSTOMER_FREQUENCY = "SELECT COUNT(o_mobilenum) AS noOfDistMobileNum, DATE(o_timestamp) as date , o_id as id from orders WHERE o_status = 'completed';";
	
	private static final String SELECT_DAILY_DISH_DRINKS = "SELECT DISTINCT oi_name AS name, SUM(oi_quantity) AS totalQuantity , DATE(o_timestamp) as date , orderitem.oi_orderid AS id from orderitem INNER JOIN orders ON orderitem.oi_orderid = orders.o_id WHERE o_timestamp LIKE ? AND o_status = 'completed' GROUP BY oi_name ORDER BY SUM(oi_quantity) DESC;";
	private static final String SELECT_WEEKLY_DISH_DRINKS = "SELECT DISTINCT oi_name AS name, SUM(oi_quantity) AS totalQuantity , DATE(o_timestamp) as date , orderitem.oi_orderid AS id from orderitem INNER JOIN orders ON orderitem.oi_orderid = orders.o_id WHERE o_timestamp BETWEEN ? AND ? && o_status = 'completed' GROUP BY oi_name ORDER BY SUM(oi_quantity) DESC;";
	private static final String SELECT_MONTHLY_DISH_DRINKS = "SELECT DISTINCT oi_name AS name, SUM(oi_quantity) AS totalQuantity , DATE(o_timestamp) as date , orderitem.oi_orderid AS id from orderitem INNER JOIN orders ON orderitem.oi_orderid = orders.o_id WHERE o_timestamp LIKE ? AND o_status = 'completed' GROUP BY oi_name ORDER BY SUM(oi_quantity) DESC;";
	
	private static final String SELECT_DAILY_AVG_SPEND = "SELECT DISTINCT DATE(o_timestamp) AS date, COUNT(o_mobilenum) AS noOfDistMobileNum , AVG(o_totalprice) AS avgSpend , o_id AS id from orders WHERE o_timestamp LIKE ? AND o_status = 'completed';";
	private static final String SELECT_WEEKLY_AVG_SPEND = "SELECT DISTINCT DATE(o_timestamp) AS date, COUNT(o_mobilenum) AS noOfDistMobileNum , AVG(o_totalprice) AS avgSpend , o_id AS id from orders WHERE o_timestamp BETWEEN ? AND ? AND o_status = 'completed';";
	private static final String SELECT_MONTHLY_AVG_SPEND = "SELECT DISTINCT DATE(o_timestamp) AS date, COUNT(o_mobilenum) AS noOfDistMobileNum , AVG(o_totalprice) AS avgSpend , o_id AS id from orders WHERE o_timestamp LIKE ? AND o_status = 'completed';";

	private static final String SELECT_DAILY_CUSTOMER_FREQUENCY = "SELECT COUNT(o_mobilenum) AS noOfDistMobileNum, DATE(o_timestamp) as date , o_id as id FROM orders WHERE o_timestamp LIKE ? AND o_status = 'completed' GROUP BY DATE(o_timestamp);";
	private static final String SELECT_WEEKLY_CUSTOMER_FREQUENCY = "SELECT COUNT(o_mobilenum) AS noOfDistMobileNum, DATE(o_timestamp) as date , o_id as id FROM orders WHERE o_timestamp BETWEEN ? AND ? AND o_status = 'completed';";
	private static final String SELECT_MONTHLY_CUSTOMER_FREQUENCY = "SELECT COUNT(o_mobilenum) AS noOfDistMobileNum, DATE(o_timestamp) as date , o_id as id FROM orders WHERE o_timestamp LIKE ? AND o_status = 'completed';";
	
	
	public List<OwnerReport> selectAllMenuItemsQuantity()
	{
		List<OwnerReport> ownerReport = new ArrayList<>();
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MENU_ITEMS_BY_QUANTITY);)
		{
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int quantity = rs.getInt("totalQuantity");
				String date = rs.getString("date");
				ownerReport.add(new OwnerReport(id, name, quantity, date));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return ownerReport;
	}
	
	public List<OwnerReport> selectCustomerAVGSpend()
	{
		List<OwnerReport> ownerReport = new ArrayList<>();
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_AVG_SPEND);)
		{
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("id");
				String date = rs.getString("date");
				double avgSpend = rs.getDouble("avgSpend");
				BigDecimal bdAvgSpend = new BigDecimal(avgSpend);
				bdAvgSpend = bdAvgSpend.setScale(2, RoundingMode.HALF_UP);
				avgSpend = bdAvgSpend.doubleValue();
				int noOfDistMobileNum = rs.getInt("noOfDistMobileNum");
				ownerReport.add(new OwnerReport(id, date, avgSpend, noOfDistMobileNum));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return ownerReport;
	}
	
	public List<OwnerReport> selectCustomerFrequency()
	{
		List<OwnerReport> ownerReport = new ArrayList<>();
		try (Connection connection = DbConnection.init();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_FREQUENCY);)
		{
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("id");
				String date = rs.getString("date");
				int noOfDistMobileNum = rs.getInt("noOfDistMobileNum");
				ownerReport.add(new OwnerReport(id, date, noOfDistMobileNum));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return ownerReport;
	}
	
	public List<OwnerReport> selectDailyDishDrinks(String date)
	{
		date = "%"+date+"%";
		List<OwnerReport> ownerReport = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DAILY_DISH_DRINKS);)
		{
			preparedStatement.setString(1, date);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int quantity = rs.getInt("totalQuantity");
				date = rs.getString("date");
				ownerReport.add(new OwnerReport(id, name, quantity, date));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return ownerReport;
	}
	
	public List<OwnerReport> selectWeeklyDishDrinks(String inputStartDate , String inputEndDate)
	{

		String endDate = inputEndDate;
		
		if (inputStartDate != null && inputEndDate != null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(sdf.parse(inputEndDate));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			c.add(Calendar.DATE, 1);  // number of days to add
			inputEndDate = sdf.format(c.getTime());  // dt is now the new date
			
		}
		
		
		List<OwnerReport> ownerReport = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WEEKLY_DISH_DRINKS);)
		{
			preparedStatement.setString(1, inputStartDate);
			preparedStatement.setString(2, inputEndDate);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int quantity = rs.getInt("totalQuantity");
				String date = rs.getString("date");
				ownerReport.add(new OwnerReport(id, name, quantity, date, inputStartDate, endDate));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return ownerReport;
	}
	
	public List<OwnerReport> selectMonthlyDishDrinks(String date)
	{
		String consDate = date;
		date = "%"+date+"%";
		List<OwnerReport> ownerReport = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MONTHLY_DISH_DRINKS);)
		{
			preparedStatement.setString(1, date);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int quantity = rs.getInt("totalQuantity");
				ownerReport.add(new OwnerReport(id, name, quantity, consDate));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return ownerReport;
	}
	
	public List<OwnerReport> selectDailyAverageSpend(String date)
	{
		date = "%"+date+"%";
		List<OwnerReport> ownerReport = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DAILY_AVG_SPEND);)
		{
			preparedStatement.setString(1, date);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int noOfDistMobileNum = rs.getInt("noOfDistMobileNum");
				double avgSpend = rs.getDouble("avgSpend");
				BigDecimal bdAvgSpend = new BigDecimal(avgSpend);
				bdAvgSpend = bdAvgSpend.setScale(2, RoundingMode.HALF_UP);
				avgSpend = bdAvgSpend.doubleValue();
				date = rs.getString("date");
				ownerReport.add(new OwnerReport(noOfDistMobileNum, avgSpend, date ));
			}
		}
		
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return ownerReport;
	}
	
	public List<OwnerReport> selectWeeklyAverageSpend(String inputStartDate , String inputEndDate)
	{

		String endDate = inputEndDate;
		
		if (inputStartDate != null && inputEndDate != null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(sdf.parse(inputEndDate));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			c.add(Calendar.DATE, 1);  // number of days to add
			inputEndDate = sdf.format(c.getTime());  // dt is now the new date
			
		}
		
		
		List<OwnerReport> ownerReport = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WEEKLY_AVG_SPEND);)
		{
			preparedStatement.setString(1, inputStartDate);
			preparedStatement.setString(2, inputEndDate);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int noOfDistMobileNum = rs.getInt("noOfDistMobileNum");
				double avgSpend = rs.getDouble("avgSpend");
				BigDecimal bdAvgSpend = new BigDecimal(avgSpend);
				bdAvgSpend = bdAvgSpend.setScale(2, RoundingMode.HALF_UP);
				avgSpend = bdAvgSpend.doubleValue();
				ownerReport.add(new OwnerReport(noOfDistMobileNum, avgSpend, inputStartDate, endDate));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return ownerReport;
	}
	
	public List<OwnerReport> selectMonthlyAverageSpend(String date)
	{
		String consDate = date;
		date = "%"+date+"%";
		List<OwnerReport> ownerReport = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MONTHLY_AVG_SPEND);)
		{
			preparedStatement.setString(1, date);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int noOfDistMobileNum = rs.getInt("noOfDistMobileNum");
				double avgSpend = rs.getDouble("avgSpend");
				BigDecimal bdAvgSpend = new BigDecimal(avgSpend);
				bdAvgSpend = bdAvgSpend.setScale(2, RoundingMode.HALF_UP);
				avgSpend = bdAvgSpend.doubleValue();
				date = rs.getString("date");
				ownerReport.add(new OwnerReport(noOfDistMobileNum, avgSpend, consDate));
			}
		}
		
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return ownerReport;
	}
	
	public List<OwnerReport> selectDailyCustomerFrequency(String date)
	{
		date = "%"+date+"%";
		List<OwnerReport> ownerReport = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DAILY_CUSTOMER_FREQUENCY);)
		{
			preparedStatement.setString(1, date);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int noOfDistMobileNum = rs.getInt("noOfDistMobileNum");
				date = rs.getString("date");
				ownerReport.add(new OwnerReport(noOfDistMobileNum, date));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return ownerReport;
	}
	
	public List<OwnerReport> selectWeeklyFrequency(String inputStartDate , String inputEndDate)
	{

		String endDate = inputEndDate;
		
		if (inputStartDate != null && inputEndDate != null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(sdf.parse(inputEndDate));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			c.add(Calendar.DATE, 1);  // number of days to add
			inputEndDate = sdf.format(c.getTime());  // dt is now the new date
			
		}
		
		
		List<OwnerReport> ownerReport = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WEEKLY_CUSTOMER_FREQUENCY);)
		{
			preparedStatement.setString(1, inputStartDate);
			preparedStatement.setString(2, inputEndDate);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int noOfDistMobileNum = rs.getInt("noOfDistMobileNum");
				ownerReport.add(new OwnerReport(noOfDistMobileNum, inputStartDate, endDate));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return ownerReport;
	}
	
	public List<OwnerReport> selectMonthlyCustomerFrequency(String date)
	{
		String consDate = date;
		date = "%"+date+"%";
		List<OwnerReport> ownerReport = new ArrayList<>();
		try (Connection connection = DbConnection.init();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MONTHLY_CUSTOMER_FREQUENCY);)
		{
			preparedStatement.setString(1, date);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) 
			{
				int noOfDistMobileNum = rs.getInt("noOfDistMobileNum");
				date = rs.getString("date");
				ownerReport.add(new OwnerReport(noOfDistMobileNum, consDate));
			}
		}
		catch (SQLException e)
		{
			printSQLException(e);
		}
		return ownerReport;
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
