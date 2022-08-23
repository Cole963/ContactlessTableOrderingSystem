package com.screamscrum.useradmin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screamscrum.useradmin.entity.UserAccount;
import com.screamscrum.useradmin.entity.UserProfile;

@WebServlet(name="AddUserAccountServlet", urlPatterns={"/newUserAccountForm", "/addUserAccount"})
public class AddUserAccountController extends HttpServlet 
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
			case "/newUserAccountForm":
				showNewUserAccountForm(request, response);
				break;
			case "/addUserAccount":
				addUserAccount(request, response);
				break;
			}
		} 
		catch (SQLException ex) 
		{
			throw new ServletException(ex);
		}
	}

	private void showNewUserAccountForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		List<UserProfile> userProfileList = UserProfile.selectAllUserProfiles();
		request.setAttribute("userProfileList", userProfileList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserAccountForm.jsp");
		dispatcher.forward(request, response);
	}

	private void addUserAccount(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException 
	{	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("fullname");
		String email = request.getParameter("email");
		String status = "active";
		int userProfileId = Integer.parseInt(request.getParameter("userProfile"));
		UserProfile userProfile = new UserProfile(userProfileId);
		UserAccount userAccount = new UserAccount(username, password, name, email, status, userProfile);
		
		HttpSession session = request.getSession();
		if (userAccount.usernameExists())
		{	
			session.setAttribute("error", "Username is already in use");
			response.sendRedirect("newUserAccountForm");
		}
		else if(userAccount.emailExists())
		{
			session.setAttribute("error", "Email is already in use");
			response.sendRedirect("newUserAccountForm");
		}
		else
		{
			boolean inserted = userAccount.insertUserAccount();
		
			if (inserted)
			{
			    session.setAttribute("userActionMessage", "User Account added");
				response.sendRedirect("viewUserAccount");
			}
		}
	}
}