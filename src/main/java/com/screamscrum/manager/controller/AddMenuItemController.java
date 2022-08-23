package com.screamscrum.manager.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.screamscrum.manager.entity.MenuItem;

@MultipartConfig
@WebServlet(name="AddMenuItemServlet", urlPatterns = {"/newMenuItemForm", "/addMenuItem"})
public class AddMenuItemController extends HttpServlet
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
		String action = request.getServletPath();
		
		try
		{
			switch (action)
			{
			case "/newMenuItemForm":
				showNewMenuItemForm(request, response);
				break;
			case "/addMenuItem":
				addMenuItem(request, response);
				break;
			}
		}
		
		catch (SQLException ex)
		{
			throw new ServletException(ex);
		}
	}
	
	private void showNewMenuItemForm(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("MenuItemForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addMenuItem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{

		Part file = request.getPart("picture");
		String imageFileName = file.getSubmittedFileName();
		String appPath = System.getProperty("user.home").replace("\\", "/");
		String rPath = "/git/screamscrum/ContactlessTableOrderingSystem/WebContent/img/";
		String uploadPath = appPath + rPath + imageFileName;
		//System.out.println(uploadPath);
		try 
		{
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = file.getInputStream();
			
			byte[] data  = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		String name = request.getParameter("name");
		double price = Double.valueOf(request.getParameter("price"));
		String picture = "img/" + imageFileName;
		
		MenuItem menuItem = new MenuItem(name, price, picture);
		menuItem.insertMenuItem();
		HttpSession session = request.getSession();
		session.setAttribute("userActionMessage", "Menu Item added");
		response.sendRedirect("viewMenuItem");
	}
}
