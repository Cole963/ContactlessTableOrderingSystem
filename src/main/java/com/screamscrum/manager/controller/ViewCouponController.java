package com.screamscrum.manager.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.screamscrum.manager.entity.*;

@MultipartConfig
@WebServlet(name = "ViewCouponsServlet", urlPatterns = {"/viewCoupons", "/viewCouponsExpired", "/viewCouponsActive"})
public class ViewCouponController extends HttpServlet 
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
			switch(action)
			{
			case "/viewCoupons":
				viewCoupons(request, response);
				break;

			case "/viewCouponsExpired":
				viewCouponsExpired(request,response);
				break;

			case "/viewCouponsActive":
				viewCouponsActive(request,response);
				break;

			}
		}
		catch (SQLException ex)
		{
			throw new ServletException(ex);
		}
	}
	
	private void viewCoupons(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException
	{
		Coupon coupon = new Coupon();
		List<Coupon> coupons = coupon.selectAllCoupons();
		request.setAttribute("coupons", coupons);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CouponView.jsp");
		dispatcher.forward(request, response);
	}

	private void viewCouponsExpired(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException
	{
		Coupon coupon = new Coupon();
		List<Coupon> coupons = coupon.selectCouponsByExpired();
		request.setAttribute("coupons", coupons);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CouponView.jsp");
		dispatcher.forward(request, response);
	}
	
	private void viewCouponsActive(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException
	{
		Coupon coupon = new Coupon();
		List<Coupon> coupons = coupon.selectCouponsByActive();
		request.setAttribute("coupons", coupons);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CouponView.jsp");
		dispatcher.forward(request, response);
	}

}
