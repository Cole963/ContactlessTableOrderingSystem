package com.screamscrum.useradmin.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screamscrum.useradmin.entity.UserProfile;

@WebServlet("/deleteUserProfile")
public class DeleteUserProfileController extends HttpServlet 
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
			UserProfile userProfile = new UserProfile(id);
			HttpSession session = request.getSession();
			
			
			if (userProfile.profileInUse())
			{	
			    session.setAttribute("userActionMessage", "User Profile is in use. It cannot be deleted.");
				response.sendRedirect("viewUserProfile");
			}
			else
			{
				boolean deleted = userProfile.deleteUserProfile();
			
				if (deleted)
				{
				    session.setAttribute("userActionMessage", "User Profile deleted");
					response.sendRedirect("viewUserProfile");
				}
			}		

		} 
		catch (SQLException ex) 
		{
			throw new ServletException(ex);
		}
	}
}