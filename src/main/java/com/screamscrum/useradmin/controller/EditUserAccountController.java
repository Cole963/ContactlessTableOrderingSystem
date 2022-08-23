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

@WebServlet(name="EditUserAccountServlet", urlPatterns={"/editUserAccountForm", "/editUserAccount"})
public class EditUserAccountController extends HttpServlet 
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
			case "/editUserAccountForm":
				showEditUserAccountForm(request, response);
				break;
			case "/editUserAccount":
				editUserAccount(request, response);
				break;
			}
		} 
		catch (SQLException ex) 
		{
			throw new ServletException(ex);
		}
	}

	private void showEditUserAccountForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		UserAccount userAccount = new UserAccount(id);
		userAccount.selectUserAccount();
		List<UserProfile> userProfileList = UserProfile.selectAllUserProfiles();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserAccountForm.jsp");
		request.setAttribute("userAccount", userAccount);
		request.setAttribute("userProfileList", userProfileList);
		dispatcher.forward(request, response);
	}

	private void editUserAccount(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("fullname");
		String email = request.getParameter("email");
		String status = "active";
		int userProfileId = Integer.parseInt(request.getParameter("userProfile"));
		UserProfile userProfile = new UserProfile(userProfileId);
		userProfile.selectUserProfile();
		UserAccount userAccount = new UserAccount(id, username, password, name, email, status, userProfile);
		
		UserAccount userAccountOriginal = new UserAccount(id);
		userAccountOriginal.selectUserAccount();
		
		HttpSession session = request.getSession();
		if (userAccount.usernameExists() && !(userAccountOriginal.getUsername().equals(username)))
		{	
			session.setAttribute("error", "Username is already in use");
			response.sendRedirect("editUserAccountForm?id="+id);
	
		}
		else if(userAccount.emailExists() && !(userAccountOriginal.getEmail().equals(email)))
		{
			session.setAttribute("error", "Email is already in use");
			response.sendRedirect("editUserAccountForm?id="+id);
		}
		else
		{
			boolean updated = userAccount.updateUserAccount();

			if (updated)
			{
			    session.setAttribute("userActionMessage", "User Account updated");
			    if(userAccountOriginal.getUsername().equals(session.getAttribute("username")))
			    {
			    	session.setAttribute("username", username);
			    	session.setAttribute("profile", userProfile.getProfile());
			    }
				response.sendRedirect("viewUserAccount");
			}
		}
	}
}