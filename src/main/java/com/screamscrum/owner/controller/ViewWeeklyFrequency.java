package com.screamscrum.owner.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.screamscrum.owner.entity.OwnerReport;

@WebServlet("/viewOwnerFrequencyWeeklyReport")
public class ViewWeeklyFrequency extends HttpServlet 
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
			String dateSelected1 = request.getParameter("selectedDateVal1");
			String dateSelected2 = request.getParameter("selectedDateVal2");
			if (dateSelected1 != null && dateSelected2 != null)
			{
			List<OwnerReport> ownerReportList = OwnerReport.selectWeeklyFrequency(dateSelected1, dateSelected2);
			request.setAttribute("ownerReportList", ownerReportList);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("OwnerFrequencyWeeklyReport.jsp");
			dispatcher.forward(request, response);
		}
		catch (Exception ex) 
		{
			throw new ServletException(ex);
		}
	}	
}