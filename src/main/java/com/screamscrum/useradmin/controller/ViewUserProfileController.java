package com.screamscrum.useradmin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.screamscrum.useradmin.entity.UserProfile;

@WebServlet("/viewUserProfile")
public class ViewUserProfileController extends HttpServlet 
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
			List<UserProfile> userProfileList = UserProfile.selectAllUserProfiles();
			request.setAttribute("userProfileList", userProfileList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UserProfileView.jsp");
			dispatcher.forward(request, response);
			
		} 
		catch (Exception ex) 
		{
			throw new ServletException(ex);
		}
	}
}