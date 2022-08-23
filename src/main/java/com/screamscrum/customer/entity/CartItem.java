package com.screamscrum.customer.entity;

import java.util.ArrayList;

import com.screamscrum.customer.dao.CartItemDAO;
import com.screamscrum.manager.entity.MenuItem;

public class CartItem extends MenuItem
{
	private int quantity;
	private double subTotalPrice;
	
	public CartItem()
	{
		
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public double getSubTotalPrice()
	{
		return subTotalPrice;
	}
	
	public void setSubTotalPrice(double subTotalPrice)
	{
		this.subTotalPrice = subTotalPrice;
	}
	
	public static ArrayList<CartItem> getCartProducts(ArrayList<CartItem> cartList)
	{
		CartItemDAO cartItemDAO = new CartItemDAO();
		return cartItemDAO.getCartProducts(cartList);
	}
	
	public static double getTotalCartPrice (ArrayList<CartItem> cartList)
	{
		CartItemDAO cartItemDAO = new CartItemDAO();
		return cartItemDAO.getTotalCartPrice(cartList);
	}
}
