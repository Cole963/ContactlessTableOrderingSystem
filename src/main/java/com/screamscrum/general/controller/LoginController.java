package com.screamscrum.general.controller;

import java.io.IOException;
///import java.sql.SQLException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.screamscrum.useradmin.entity.UserAccount;

@WebServlet("/login")

public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserAccount userAccount = new UserAccount();
		userAccount.setUsername(username);
		userAccount.setPassword(password);
		HttpSession session = request.getSession();
		
		if(userAccount.login()) 
		{	
			String profile = userAccount.getUserprofile().getProfile();
			session.setAttribute("username", username);
			session.setAttribute("profile", profile);
			response.sendRedirect("StaffHomePage.jsp");
		}
		else
		{
			session.setAttribute("error", "Login failed. Incorrect username or password.");
			response.sendRedirect("LoginForm.jsp");
		}
	}

}