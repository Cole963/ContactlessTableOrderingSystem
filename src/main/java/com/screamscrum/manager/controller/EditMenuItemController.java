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
@WebServlet(name = "EditMenuItemServlet", urlPatterns = {"/editMenuItemForm", "/editMenuItem"})
public class EditMenuItemController extends HttpServlet
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
			switch(action)
			{
			case "/editMenuItemForm":
				showEditMenuItemForm(request, response);
				break;
			case "/editMenuItem":
				editMenuItem(request, response);
			}
		}
		catch (SQLException ex)
		{
			throw new ServletException(ex);
		}
	}
	
	private void showEditMenuItemForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		MenuItem menuItem = new MenuItem(id);
		menuItem = menuItem.selectMenuItemById();
		RequestDispatcher dispatcher = request.getRequestDispatcher("MenuItemForm.jsp");
		request.setAttribute("menuItem", menuItem);
		dispatcher.forward(request, response);
	}
	
	private void editMenuItem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{
		Part file = request.getPart("picture");
		String imageFileName = file.getSubmittedFileName();
		String appPath = System.getProperty("user.home").replace("\\", "/");
		String rPath = "/git/screamscrum/ContactlessTableOrderingSystem/WebContent/img/";
		String uploadPath = appPath + rPath + imageFileName;
		//System.out.println(uploadPath);
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double price = Double.valueOf(request.getParameter("price"));
		
		if(imageFileName == "")
		{
			MenuItem menuItem = new MenuItem(id, name, price);
			menuItem.updateMenuItemWithoutImage();
		}
		else
		{
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
			

			String picture = "img/" + imageFileName;
			MenuItem menuItem = new MenuItem(id, name, price, picture);
			menuItem.updateMenuItem();
		}
		HttpSession session = request.getSession();
		session.setAttribute("userActionMessage", "Menu Item updated");
		response.sendRedirect("viewMenuItem");
	}
}
