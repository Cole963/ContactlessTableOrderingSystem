package com.screamscrum.manager.controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screamscrum.manager.entity.*;

@MultipartConfig
@WebServlet(name="AddCouponServlet", urlPatterns = {"/newCouponForm", "/addCoupon"})
public class AddCouponController extends HttpServlet {
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
			case "/newCouponForm":
				showNewCouponForm(request, response);
				break;
			case "/addCoupon":
				addCoupon(request, response);
				break;
			}
		}
		
		catch (SQLException ex)
		{
			throw new ServletException(ex);
		}
	}
	
	private void showNewCouponForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("CouponForm.jsp");
			dispatcher.forward(request, response);
		}

	private void addCoupon(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{		
		String code = request.getParameter("code");
		String status = "active";
		
		Coupon coupon = new Coupon(code, status);
		coupon.insertCoupon();
		HttpSession session = request.getSession();
		session.setAttribute("userActionMessage", "Coupon added");
		response.sendRedirect("viewCoupons");
	}


}
