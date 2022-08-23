package com.screamscrum.useradmin.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screamscrum.useradmin.entity.UserAccount;

@WebServlet("/suspendUserAccount")
public class SuspendUserAccountController extends HttpServlet 
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
			String status = request.getParameter("status");
			UserAccount userAccount = new UserAccount(id);
			userAccount.setStatus(status);
			boolean statusUpdated = userAccount.updateUserAccountStatus();
			
			if (statusUpdated)
			{
			    HttpSession session = request.getSession();
			    if (status.equals("active"))
			    {
			    	session.setAttribute("userActionMessage", "User Account unsuspended");
			    }
			    else
			    {
			    	session.setAttribute("userActionMessage", "User Account suspended");
			    }
				response.sendRedirect("viewUserAccount");
			}

		} 
		catch (SQLException ex) 
		{
			throw new ServletException(ex);
		}
	}
}