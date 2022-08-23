package com.screamscrum.manager.entity;

import java.sql.SQLException;
import java.util.List;

import com.screamscrum.manager.dao.*;

public class Coupon 
{
	protected int id;
	protected String code;
	protected String status;
	private CouponDAO couponDAO;
	
	public Coupon() 
	{
		couponDAO = new CouponDAO();
	}
	
	public Coupon(int id)
	{
		this.id = id;
		couponDAO = new CouponDAO();
	}
	
	public Coupon(String code, String status)
	{
		this.code = code;
		this.status = status;
		couponDAO = new CouponDAO();		
	}
	
	public Coupon(int id, String code, String status) 
	{
		this.id = id;
		this.code = code;
		this.status = status;
		couponDAO = new CouponDAO();
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getCode() 
	{
		return code;
	}
	
	public void setCode(String code) 
	{
		this.code = code;
	}
	
	public String getStatus() 
	{
		return status;
	}
	
	public void setStatus(String status) 
	{
		this.status = status;
	}
	
	public List<Coupon> selectAllCoupons()
	{
		return couponDAO.selectAllCoupons();
	}
	
	public List<Coupon> selectCouponsByActive()
	{
		return couponDAO.selectCouponsByActive();
	}
	
	public List<Coupon> selectCouponsByExpired()
	{
		return couponDAO.selectCouponsByExpired();
	}
	
	public List<Coupon> searchCoupons(String input)
	{
		return couponDAO.searchCoupons(input);
	}
	
	public Coupon selectCouponById()
	{
		return couponDAO.selectCouponById(this.id);
	}
	
	public void insertCoupon () throws SQLException
	{
		couponDAO.insertCoupon(this);
	}
	
	public boolean deleteCoupon() throws SQLException
	{
		return couponDAO.deleteCoupon(this.id);
	}
	
	public boolean updatecoupon() throws SQLException
	{
		return couponDAO.updateCoupon(this);
	}
	
}
