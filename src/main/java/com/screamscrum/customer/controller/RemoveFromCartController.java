package com.screamscrum.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screamscrum.customer.entity.CartItem;

/**
 * Servlet implementation class removeFromCart
 */
@WebServlet("/removeFromCart")
public class RemoveFromCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try(PrintWriter out = response.getWriter())
		{
			String id = request.getParameter("id");
		
			if(id != null)
			{	
				HttpSession session = request.getSession();
				ArrayList<CartItem> cart_list = (ArrayList<CartItem>) session.getAttribute("sessionCartList");
				
				if(cart_list != null)
				{
					for(CartItem c : cart_list)
					{
						if(c.getId() == Integer.parseInt(id))
						{
							cart_list.remove(cart_list.indexOf(c));
							break;
						}
					}
					cart_list = CartItem.getCartProducts(cart_list);
					double total = CartItem.getTotalCartPrice(cart_list);
					session.setAttribute("sessionCartList", cart_list);
					session.setAttribute("total", total);
					response.sendRedirect("Cart.jsp");
				}
			}
			else
			{
				response.sendRedirect("Cart.jsp");
			}
		}
	}

}
