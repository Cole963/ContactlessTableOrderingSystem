package com.screamscrum.owner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.screamscrum.owner.entity.OwnerReport;

@WebServlet("/viewOwnerAverageSpendReport")
public class ViewOverallAverageSpend extends HttpServlet 
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
			List<OwnerReport> ownerReportList = OwnerReport.selectCustomerAVGSpend();
			request.setAttribute("ownerReportList", ownerReportList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("OwnerAverageSpendReport.jsp");
			dispatcher.forward(request, response);
			
		} 
		catch (Exception ex) 
		{
			throw new ServletException(ex);
		}
	}
}