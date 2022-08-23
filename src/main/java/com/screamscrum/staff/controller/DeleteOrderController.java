package com.screamscrum.staff.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screamscrum.staff.entity.Order;

@WebServlet("/deleteOrder")
public class DeleteOrderController extends HttpServlet 
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
			order.deleteOrder();
			HttpSession session = request.getSession();
			session.setAttribute("userActionMessage", "Order deleted");
			response.sendRedirect("viewOrder");			
		} 
		catch (Exception ex) 
		{
			throw new ServletException(ex);
		}
	}
}