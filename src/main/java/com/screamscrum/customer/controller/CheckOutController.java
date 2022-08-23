package com.screamscrum.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.screamscrum.customer.entity.CartItem;
import com.screamscrum.staff.entity.*;
import com.screamscrum.useradmin.entity.UserProfile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cartCheckOut")
public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try(PrintWriter out = response.getWriter())
		{
			HttpSession session = request.getSession();
			
			// format for date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");			
			Date date = new Date();
			
			//retrieve all cart products and total price
			ArrayList<CartItem> cart_list = (ArrayList<CartItem>) session.getAttribute("sessionCartList");
			
			//retrieve the mobile number
			int mobileNum = Integer.parseInt(request.getParameter("mobileNum"));
			
			if (cart_list != null && cart_list.size() > 0)
			{
				double totalPrice = (double) session.getAttribute("total");
				//this code will insert the data into order table
				Order order = new Order();
				order.setMobileNum(mobileNum);
				order.setTimeStamp(sdf.format(date));
				order.setStatus("preparing");
				order.setTotalPrice(totalPrice);
				order.insertOrder();
				int id = order.selectOrderId();

				//This code will loop and put everything inside the cart to the orderitem table
				for(CartItem c : cart_list)
				{
					OrderItem orderItem = new OrderItem();
					orderItem.setName(c.getName());
					
					int quantity = c.getQuantity();
					double subTotalPrice = c.getSubTotalPrice();
					double unitPrice = subTotalPrice / quantity;
					
					orderItem.setQuantity(quantity);
					orderItem.setUnitPrice(unitPrice);
					orderItem.setSubTotalPrice(subTotalPrice);
					orderItem.setOrderId(id);
					boolean inserted = orderItem.insertOrderItem();
					
					if (!inserted)
					{
						break;
					}
				}
				request.setAttribute("cartList", cart_list);
				request.setAttribute("total", totalPrice);
				RequestDispatcher dispatcher = request.getRequestDispatcher("CheckOut.jsp");
				session.removeAttribute("sessionCartList");
				session.removeAttribute("total");
				dispatcher.forward(request, response);
			}
			else
			{
				response.sendRedirect("Cart.jsp");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
