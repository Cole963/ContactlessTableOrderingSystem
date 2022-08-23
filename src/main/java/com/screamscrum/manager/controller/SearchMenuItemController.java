package com.screamscrum.manager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.screamscrum.manager.entity.MenuItem;

@WebServlet(name = "searchMenuItemServlet", urlPatterns = {"/searchMenuItem", "/searchMenuItemCustomer"})
public class SearchMenuItemController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException
	{
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		String action = request.getServletPath();
		try
		{
			String input = request.getParameter("searchInput");
			MenuItem menuItem = new MenuItem(input);
			List<MenuItem> menuItemList = menuItem.selectMenuItemByName();
			request.setAttribute("menuItemList", menuItemList);
			
			RequestDispatcher dispatcher = null;
			if(action.equals("/searchMenuItem"))
			{
				dispatcher = request.getRequestDispatcher("MenuItemView.jsp");
			}
			else if(action.equals("/searchMenuItemCustomer"))
			{
				dispatcher = request.getRequestDispatcher("MainPage.jsp");
			}
			dispatcher.forward(request, response);
		}
		catch (Exception ex)
		{
			throw new ServletException(ex);
		}
	}
}
