package com.screamscrum.staff.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.screamscrum.staff.entity.Order;
import com.screamscrum.staff.entity.OrderItem;

@WebServlet("/viewOrderItem")
public class ViewOrderItemController extends HttpServlet 
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
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			Order order = new Order(orderId);
			order.selectOrder();
			String status = order.getStatus();
			List<OrderItem> orderItemList = OrderItem.selectOrderItemsByOrderId(orderId);
			
			request.setAttribute("orderId", orderId);
			request.setAttribute("orderStatus", status);
			request.setAttribute("orderItemList", orderItemList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("OrderItemView.jsp");
			dispatcher.forward(request, response);
			
		} 
		catch (Exception ex) 
		{
			throw new ServletException(ex);
		}
	}
}