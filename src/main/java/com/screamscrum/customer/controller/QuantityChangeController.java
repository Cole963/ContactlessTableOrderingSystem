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

@WebServlet("/quantityChange")
public class QuantityChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter();)
		{
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			
			HttpSession session = request.getSession();
			ArrayList<CartItem> cart_list = (ArrayList<CartItem>)session.getAttribute("sessionCartList");
			
			if(action != null && id >= 1)
			{
				if(action.equals("inc"))
				{
					for(CartItem c : cart_list)
					{
						if(c.getId() == id)
						{
							int quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
							
							cart_list = CartItem.getCartProducts(cart_list);
							double total = CartItem.getTotalCartPrice(cart_list);
							session.setAttribute("sessionCartList", cart_list);
							session.setAttribute("total", total);
							response.sendRedirect("Cart.jsp");
						}
					}
				}
				else if(action.equals("dec"))
				{
					for(CartItem c : cart_list)
					{
						if(c.getId() == id && c.getQuantity() > 1)
						{
							int quantity = c.getQuantity();
							quantity--;
							c.setQuantity(quantity);
							cart_list = CartItem.getCartProducts(cart_list);
							double total = CartItem.getTotalCartPrice(cart_list);
							session.setAttribute("sessionCartList", cart_list);
							session.setAttribute("total", total);
							break;
						}
					}
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
