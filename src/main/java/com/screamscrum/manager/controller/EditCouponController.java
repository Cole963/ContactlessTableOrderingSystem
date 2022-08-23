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
@WebServlet(name = "EditCouponServlet", urlPatterns = {"/editCouponForm", "/editCoupon"})

public class EditCouponController extends HttpServlet {
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
			case "/editCouponForm":
				showEditCouponForm(request, response);
				break;
			case "/editCoupon":
				editCoupon(request,response);
			}
		}
		catch (SQLException ex)
		{
			throw new ServletException(ex);
		}
	}
	
	private void showEditCouponForm(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Coupon coupon = new Coupon(id);
		coupon = coupon.selectCouponById();
		RequestDispatcher dispatcher = request.getRequestDispatcher("CouponForm.jsp");
		request.setAttribute("coupon", coupon);
		dispatcher.forward(request, response);
	}
	
	private void editCoupon(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String code = request.getParameter("code");
		String status = request.getParameter("status");
		
		Coupon coupon = new Coupon(id,code,status);
		coupon.updatecoupon();
		HttpSession session = request.getSession();
		session.setAttribute("userActionMessage", "Coupon updated");
		response.sendRedirect("viewCoupons");
	}


}
