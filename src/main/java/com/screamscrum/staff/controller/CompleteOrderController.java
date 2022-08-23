package com.screamscrum.staff.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screamscrum.staff.entity.Order;

@WebServlet("/completeOrder")
public class CompleteOrderController extends HttpServlet 
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
			int id = Integer.parseInt(request.getParameter("orderId"));
			Order order = new Order(id);
			order.setStatus("completed");
			boolean statusUpdated = order.updateOrderStatus();
			
			if (statusUpdated)
			{
			    HttpSession session = request.getSession();
			    session.setAttribute("userActionMessage", "Order marked as completed");
				response.sendRedirect("viewOrder");
			}

		} 
		catch (SQLException ex) 
		{
			throw new ServletException(ex);
		}
	}
}