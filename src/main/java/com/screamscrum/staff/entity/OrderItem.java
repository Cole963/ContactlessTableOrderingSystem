package com.screamscrum.staff.entity;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import com.screamscrum.staff.dao.OrderItemDAO;

public class OrderItem {
	private int id;
	private String name;
	private double unitPrice;
	private int quantity;
	private double subTotalPrice;
	private int orderId; 
	private OrderItemDAO orderItemDAO;
	
	public OrderItem() {
		orderItemDAO = new OrderItemDAO();
	}
	
	public OrderItem(int id) {
		this.id = id;
		orderItemDAO = new OrderItemDAO();
	}
	
	public OrderItem(String name, double unitPrice, int quantity, double subTotalPrice) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.subTotalPrice = subTotalPrice;
		orderItemDAO = new OrderItemDAO();
	}
	
	public OrderItem(int id, String name, double unitPrice, int quantity, double subTotalPrice) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.subTotalPrice = subTotalPrice;
		orderItemDAO = new OrderItemDAO();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubTotalPrice() {
		return subTotalPrice;
	}

	public void setSubTotalPrice(double subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public static List<OrderItem> selectOrderItemsByOrderId(int oid) {
		OrderItemDAO orderItemDAO = new OrderItemDAO();
		return orderItemDAO.selectOrderItemsByOrderId(oid);
	}
	
	public static List<OrderItem> searchOrderItems(String input, int orderId) {
		OrderItemDAO orderItemDAO = new OrderItemDAO();
		return orderItemDAO.searchOrderItems(input, orderId);
	}
	
	public void selectOrderItem() {
		Hashtable<String, String> values = orderItemDAO.selectOrderItem(id);
		name = values.get("name");
		unitPrice = Double.parseDouble(values.get("unitPrice"));
		quantity = Integer.parseInt(values.get("quantity"));
		subTotalPrice = Double.parseDouble(values.get("subTotalPrice"));
		orderId = Integer.parseInt(values.get("orderId"));
	}
	
	public boolean insertOrderItem() throws SQLException {
		boolean inserted = orderItemDAO.insertOrderItem(name, unitPrice, quantity, subTotalPrice, orderId);
		return inserted;
	}
	
	public boolean deleteOrderItem() throws SQLException {
		boolean deleted = orderItemDAO.deleteOrderItem(id);
		return deleted;
	}
	
	public boolean updateOrderItem() throws SQLException {
		boolean updated = orderItemDAO.updateOrderItem(quantity, subTotalPrice, id);
		return updated;
	}
}
