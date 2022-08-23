package com.screamscrum.owner.entity;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.List;

import com.screamscrum.manager.dao.MenuItemDAO;
import com.screamscrum.manager.entity.MenuItem;
import com.screamscrum.owner.dao.OwnerDAO;
import com.screamscrum.useradmin.dao.UserAccountDAO;
import com.screamscrum.useradmin.entity.UserAccount;

public class OwnerReport {
	protected int id;
	protected String name;
	protected int quantity;
	protected String date;
	protected double avgSpend;
	private OwnerDAO OwnerDAO;
	protected int noOfDistMobileNum;
	protected int mobileNum;
	protected String startDate;
	protected String endDate;
	protected int mobileNumCount;

	public OwnerReport() {
		OwnerDAO = new OwnerDAO();
	}
	
	public OwnerReport(int id) {
		this.id = id;
		OwnerDAO = new OwnerDAO();
	}
	
	public OwnerReport(String date) {
		super();
		this.date = date;
		OwnerDAO = new OwnerDAO();
	}

	public OwnerReport(String name, int quantity, String date) {
		this.name = name;
		this.quantity = quantity;
		this.date = date;
		OwnerDAO = new OwnerDAO();
	}

	public OwnerReport(int id, String name, int quantity, String date) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.date = date;
		OwnerDAO = new OwnerDAO();
	}
	
	public OwnerReport(int id, String date, int noOfDistMobileNum) {
		super();
		this.date = date;
		this.noOfDistMobileNum = noOfDistMobileNum;
		OwnerDAO = new OwnerDAO();
	}
	
	public OwnerReport(int id, String date, double avgSpend, int noOfDistMobileNum) {
		super();
		this.date = date;
		this.avgSpend = avgSpend;
		this.noOfDistMobileNum = noOfDistMobileNum;
		OwnerDAO = new OwnerDAO();
	}

	public OwnerReport(int noOfDistMobileNum, double avgSpend, String date) {
		super();
		this.noOfDistMobileNum = noOfDistMobileNum;
		this.avgSpend = avgSpend;
		this.date = date;
		OwnerDAO = new OwnerDAO();
	}
	
	public OwnerReport(String date, int noOfDistMobileNum, int mobileNum) {
		super();
		this.noOfDistMobileNum = noOfDistMobileNum;
		this.mobileNum = mobileNum;
		this.date = date;
		OwnerDAO = new OwnerDAO();
	}
	
	public OwnerReport(int id, String name, int quantity , String date, String startDate , String endDate) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.date = date;
		this.startDate = startDate;
		this.endDate = endDate;
		OwnerDAO = new OwnerDAO();
	}
	
	public OwnerReport(int mobileNumCount, double avgSpend ,String startDate , String endDate) {
		this.mobileNumCount = mobileNumCount;
		this.avgSpend = avgSpend;
		this.startDate = startDate;
		this.endDate = endDate;
		OwnerDAO = new OwnerDAO();
	}
	
	public OwnerReport( int noOfDistMobileNum,String startDate , String endDate) {
		this.noOfDistMobileNum = noOfDistMobileNum;
		this.startDate = startDate;
		this.endDate = endDate;
		OwnerDAO = new OwnerDAO();
	}
	
	public OwnerReport(int noOfDistMobileNum, String date) {
		super();
		this.noOfDistMobileNum = noOfDistMobileNum;
		this.date = date;
		OwnerDAO = new OwnerDAO();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getMobileNumCount() {
		return mobileNumCount;
	}

	public void setMobileNumCount(int mobileNumCount) {
		this.mobileNumCount = mobileNumCount;
	}
	
	public int getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(int mobileNum) {
		this.mobileNum = mobileNum;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getstartDate() {
		return startDate;
	}

	public void setstartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getendDate() {
		return endDate;
	}

	public void setendDate(String endDate) {
		this.endDate = endDate;
	}
	
	public double getavgSpend() {
		return avgSpend;
	}

	public void setavgSpend(double avgSpend) {
		this.avgSpend = avgSpend;
	}
	
	public int getNoOfDistMobileNum() {
		return noOfDistMobileNum;
	}

	public void setNoOfDistMobileNum(int noOfDistMobileNum) {
		this.noOfDistMobileNum = noOfDistMobileNum;
	}

	public static List<OwnerReport> selectAllMenuItemsQuantity() {
		OwnerDAO OwnerDAO = new OwnerDAO();
		return OwnerDAO.selectAllMenuItemsQuantity();
	}
	
	public static List<OwnerReport> selectCustomerAVGSpend() {
		OwnerDAO OwnerDAO = new OwnerDAO();
		return OwnerDAO.selectCustomerAVGSpend();
	}
	
	public static List<OwnerReport> selectCustomerFrequency() {
		OwnerDAO OwnerDAO = new OwnerDAO();
		return OwnerDAO.selectCustomerFrequency();
	}
	
	public static List<OwnerReport> selectDailyDishDrinks(String input)
	{
		OwnerDAO ownerDAO = new OwnerDAO();
		return ownerDAO.selectDailyDishDrinks(input);
	}
	
	public static List<OwnerReport> selectDailyAverageSpend(String input)
	{
		OwnerDAO ownerDAO = new OwnerDAO();
		return ownerDAO.selectDailyAverageSpend(input);
	}
	
	public static List<OwnerReport> selectDailyCustomerFrequency(String input)
	{
		OwnerDAO ownerDAO = new OwnerDAO();
		return ownerDAO.selectDailyCustomerFrequency(input);
	}
	
	public static List<OwnerReport> selectWeeklyDishDrinks(String inputStartDate , String inputEndDate)
	{
		OwnerDAO ownerDAO = new OwnerDAO();
		return ownerDAO.selectWeeklyDishDrinks(inputStartDate , inputEndDate);
	}
	
	public static List<OwnerReport> selectWeeklyAverageSpend(String inputStartDate , String inputEndDate)
	{
		OwnerDAO ownerDAO = new OwnerDAO();
		return ownerDAO.selectWeeklyAverageSpend(inputStartDate , inputEndDate);
	}
	
	public static List<OwnerReport> selectWeeklyFrequency(String inputStartDate , String inputEndDate)
	{
		OwnerDAO ownerDAO = new OwnerDAO();
		return ownerDAO.selectWeeklyFrequency(inputStartDate , inputEndDate);
	}
	
	public static List<OwnerReport> selectMonthlyDishDrinks(String input)
	{
		OwnerDAO ownerDAO = new OwnerDAO();
		return ownerDAO.selectMonthlyDishDrinks(input);
	}
	
	public static List<OwnerReport> selectMonthlyAverageSpend(String input)
	{
		OwnerDAO ownerDAO = new OwnerDAO();
		return ownerDAO.selectMonthlyAverageSpend(input);
	}
	
	public static List<OwnerReport> selectMonthlyCustomerFrequency(String input)
	{
		OwnerDAO ownerDAO = new OwnerDAO();
		return ownerDAO.selectMonthlyCustomerFrequency(input);
	}
}
