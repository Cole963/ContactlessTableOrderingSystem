package com.screamscrum.staff.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screamscrum.staff.entity.Order;
import com.screamscrum.staff.entity.OrderItem;

@WebServlet("/editOrderItemQty")
public class EditOrderItemController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		try 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			OrderItem orderItem = new OrderItem(id);
			orderItem.selectOrderItem();
			double newSubTotalPrice = orderItem.getUnitPrice() * quantity;
			orderItem.setQuantity(quantity);
			orderItem.setSubTotalPrice(newSubTotalPrice);
			orderItem.updateOrderItem();
			int orderId = orderItem.getOrderId();
			
			Order order = new Order(orderId);
			order.selectOrder();
			double totalPrice = order.calculateTotalPriceOfOrderItems();
			String status = order.getStatus();
			order.updateOrderTotalPrice(totalPrice);
			
			List<OrderItem> orderItemList = OrderItem.selectOrderItemsByOrderId(orderId);
			request.setAttribute("orderId", orderId);
			request.setAttribute("orderStatus", status);
			request.setAttribute("orderItemList", orderItemList);
			
			HttpSession session = request.getSession();
			session.setAttribute("userActionMessage", "Order Item updated");
			RequestDispatcher dispatcher = request.getRequestDispatcher("OrderItemView.jsp");
			dispatcher.forward(request, response);
			
		} 
		catch (Exception ex) 
		{
			throw new ServletException(ex);
		}
	}
}