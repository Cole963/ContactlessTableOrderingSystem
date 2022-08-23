package com.screamscrum.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.screamscrum.customer.entity.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addToCart")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter())
		{
			ArrayList<CartItem> cartList = new ArrayList<>();
			
			int id = Integer.parseInt(request.getParameter("id"));
			CartItem cm = new CartItem();
			cm.setId(id);
			cm.setQuantity(1);
			
			HttpSession session = request.getSession();
			ArrayList<CartItem> cart_list = (ArrayList<CartItem>) session.getAttribute("sessionCartList");
			
			if(cart_list == null)
			{
				cartList.add(cm);
				cartList = CartItem.getCartProducts(cartList);
				double total = CartItem.getTotalCartPrice(cartList);
				session.setAttribute("sessionCartList", cartList);
				session.setAttribute("total", total);
				response.sendRedirect("welcome");
			}
			else
			{
				cartList = cart_list;
				boolean inTheCart = false;
				
				for (CartItem c:cart_list)
				{
					if (c.getId() == id)
					{
						inTheCart = true;
//						out.println("<h3 style ='color:crimson; text-align: center'> Item already exist in Cart. <a href ='cart.jsp'> Go to cart page to check it </a></h3> ");
					}
				}
				
				if(!inTheCart)
				{
					cartList.add(cm);
					cartList = CartItem.getCartProducts(cartList);
					double total = CartItem.getTotalCartPrice(cartList);
					session.setAttribute("sessionCartList", cartList);
					session.setAttribute("total", total);
					response.sendRedirect("welcome");
				}
				
				else if (inTheCart == true)
				{
					session.setAttribute("userActionMessage", "The item is already in the cart");
					response.sendRedirect("welcome");
				}
			}
		}
	}

}
