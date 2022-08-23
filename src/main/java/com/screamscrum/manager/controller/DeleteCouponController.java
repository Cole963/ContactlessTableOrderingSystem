package com.screamscrum.manager.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screamscrum.manager.entity.*;


@WebServlet("/deleteCoupon")
public class DeleteCouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		try
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Coupon coupon = new Coupon(id);
			coupon.deleteCoupon();
			HttpSession session = request.getSession();
			session.setAttribute("userActionMessage", "Coupon deleted");
			response.sendRedirect("viewCoupons");
		}
		catch(SQLException ex)
		{
			throw new ServletException(ex);
		}
	}

}
