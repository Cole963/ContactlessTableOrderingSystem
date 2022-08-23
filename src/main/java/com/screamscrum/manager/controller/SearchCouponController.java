package com.screamscrum.manager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.screamscrum.manager.entity.Coupon;

@WebServlet("/searchCoupon")
public class SearchCouponController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException
	{
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		try 
		{	
			String input = request.getParameter("searchInput");
			Coupon coupon = new Coupon();
			List<Coupon> coupons = coupon.searchCoupons(input);
			request.setAttribute("coupons", coupons);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CouponView.jsp");
			dispatcher.forward(request, response);
		} 
		catch (Exception ex) 
		{
			throw new ServletException(ex);
		}
	}
}
