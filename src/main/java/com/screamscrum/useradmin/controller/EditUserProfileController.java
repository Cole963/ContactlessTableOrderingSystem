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

@WebServlet(name="EditUserProfileServlet", urlPatterns={"/editUserProfileForm", "/editUserProfile"})
public class EditUserProfileController extends HttpServlet 
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
			case "/editUserProfileForm":
				showEditUserProfileForm(request, response);
				break;
			case "/editUserProfile":
				editUserProfile(request, response);
				break;
			}
		} 
		catch (SQLException ex) 
		{
			throw new ServletException(ex);
		}
	}

	private void showEditUserProfileForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		UserProfile userProfile = new UserProfile(id);
		userProfile.selectUserProfile();
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserProfileForm.jsp");
		request.setAttribute("userProfile", userProfile);
		dispatcher.forward(request, response);
	}

	private void editUserProfile(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String profile = request.getParameter("profile");
		String description = request.getParameter("description");
		UserProfile userProfile = new UserProfile(id, profile, description);
		
		UserProfile userProfileOriginal = new UserProfile(id);
		userProfileOriginal.selectUserProfile();
		
		
		HttpSession session = request.getSession();
		if ((userProfileOriginal.getProfile().equals(profile) || (!userProfile.profileExists())))
		{	
			boolean updated = userProfile.updateUserProfile();
			
			if (updated)
			{
			    session.setAttribute("userActionMessage", "User Profile updated");
			    if(userProfileOriginal.getProfile().equals(session.getAttribute("profile")))
			    {
			    	session.setAttribute("profile", userProfile.getProfile());
			    }
				response.sendRedirect("viewUserProfile");
			}
		}
		else 
		{
			session.setAttribute("error", "There is a duplicate profile name");
			response.sendRedirect("editUserProfileForm?id="+id);
		}
	}
}