package com.screamscrum.staff.entity;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import com.screamscrum.staff.dao.OrderDAO;

public class Order {
	private int id;
	private String timeStamp;
	private int mobileNum;
	private double totalPrice;
	private String status;
	private OrderDAO orderDAO;
	
	public Order() {
		orderDAO = new OrderDAO();
	}
	
	public Order(int id) {
		this.id = id;
		orderDAO = new OrderDAO();
	}
	
	public Order(String timeStamp, int mobileNum, double totalPrice, String status) {
		this.timeStamp = timeStamp;
		this.mobileNum = mobileNum;
		this.totalPrice = totalPrice;
		this.status = status;
		orderDAO = new OrderDAO();
	}
	
	public Order(int id, String timeStamp, int mobileNum, double totalPrice, String status) {
		this.id = id;
		this.timeStamp = timeStamp;
		this.mobileNum = mobileNum;
		this.totalPrice = totalPrice;
		this.status = status;
		orderDAO = new OrderDAO();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(int mobileNum) {
		this.mobileNum = mobileNum;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public static List<Order> selectAllOrders() {
		OrderDAO orderDAO = new OrderDAO();
		return orderDAO.selectAllOrders();
	}
	
	public static List<Order> searchOrders(String input) {
		OrderDAO orderDAO = new OrderDAO();
		return orderDAO.searchOrders(input);
	}
	
	public void selectOrder() {
		Hashtable<String, String> values = orderDAO.selectOrder(id);
		timeStamp = values.get("timeStamp");
		mobileNum = Integer.parseInt(values.get("mobileNum"));
		totalPrice = Double.parseDouble(values.get("totalPrice"));
		status = values.get("status");
	}
	
	public boolean insertOrder() throws SQLException {
		boolean deleted = orderDAO.insertOrder(timeStamp, mobileNum, totalPrice, status);
		return deleted;
	}
	
	public boolean deleteOrder() throws SQLException {
		boolean deleted = orderDAO.deleteOrder(id);
		return deleted;
	}
	
	public boolean updateOrderStatus() throws SQLException {
		boolean updated = orderDAO.updateOrderStatus(status, id);
		return updated;
	}
	
	public boolean updateMobileNum() throws SQLException {
		boolean updated = orderDAO.updateMobileNum(mobileNum, id);
		return updated;
	}
	
	public boolean updateOrderTotalPrice(double totalPrice) throws SQLException {
		boolean updated = orderDAO.updateOrderTotalPrice(totalPrice, id);
		return updated;
	}
	
	public int selectOrderId() throws SQLException {
		int id = orderDAO.selectOrderId(timeStamp, mobileNum);
		return id;
	}
	
	public double calculateTotalPriceOfOrderItems() throws SQLException 
	{
		double totalPrice = orderDAO.calculateTotalPriceOfOrderItems(id);
		return totalPrice;
	}
}
