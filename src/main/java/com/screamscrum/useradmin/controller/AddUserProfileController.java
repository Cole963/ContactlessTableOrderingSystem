package com.screamscrum.useradmin.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screamscrum.useradmin.entity.UserProfile;

@WebServlet(name="AddUserProfileServlet", urlPatterns={"/newUserProfileForm", "/addUserProfile"})
public class AddUserProfileController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getServletPath();

		try 
		{
			switch (action) 
			{
			case "/newUserProfileForm":
				showNewUserProfileForm(request, response);
				break;
			case "/addUserProfile":
				addUserProfile(request, response);
				break;
			}
		} 
		catch (SQLException ex) 
		{
			throw new ServletException(ex);
		}
	}

	private void showNewUserProfileForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserProfileForm.jsp");
		dispatcher.forward(request, response);
	}

	private void addUserProfile(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException 
	{
		String profile = request.getParameter("profile");
		String description = request.getParameter("description");
		UserProfile userProfile = new UserProfile(profile, description);
		
		HttpSession session = request.getSession();
		if (userProfile.profileExists())
		{	
			session.setAttribute("error", "There is a duplicate profile name");
			response.sendRedirect("newUserProfileForm");
		}
		else
		{
			boolean inserted = userProfile.insertUserProfile();
		
			if (inserted)
			{
			    session.setAttribute("userActionMessage", "User Profile added");
				response.sendRedirect("viewUserProfile");
			}
		}		
	}
}