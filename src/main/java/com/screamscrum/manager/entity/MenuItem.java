package com.screamscrum.manager.entity;

import java.sql.SQLException;
import java.util.List;

import com.screamscrum.manager.dao.MenuItemDAO;

public class MenuItem {
	protected int id;
	protected String name;
	protected double price;
	protected String picture;
	private MenuItemDAO menuItemDAO;
	
	public MenuItem() {
		menuItemDAO = new MenuItemDAO();
	}
	
	public MenuItem(int id) {
		super();
		this.id = id;
		menuItemDAO = new MenuItemDAO();
	}
	
	public MenuItem(String name) {
		super();
		this.name = name;
		menuItemDAO = new MenuItemDAO();
	}

	public MenuItem(int id, String name, double price, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.picture = picture;
		menuItemDAO = new MenuItemDAO();
	}

	public MenuItem(String name, double price, String picture) {
		super();
		this.name = name;
		this.price = price;
		this.picture = picture;
		menuItemDAO = new MenuItemDAO();
	}
	
	public MenuItem(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		menuItemDAO = new MenuItemDAO();
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void insertMenuItem() throws SQLException
	{
		menuItemDAO.insertMenuItem(this);
	}
	
	public MenuItem selectMenuItemById()
	{
		return menuItemDAO.selectMenuItemById(this.id);
	}
	
	public List<MenuItem> selectMenuItemByName()
	{
		return menuItemDAO.selectMenuItemByName(this.name);
	}
	
	public List<MenuItem> selectAllMenuItems()
	{
		return menuItemDAO.selectAllMenuItems();
	}
	
	public boolean deleteMenuItem() throws SQLException
	{
		return menuItemDAO.deleteMenuItem(this.id);
	}

	public boolean updateMenuItem() throws SQLException
	{
		return menuItemDAO.updateMenuItem(this);
	}
	
	public boolean updateMenuItemWithoutImage() throws SQLException
	{
		return menuItemDAO.updateMenuItemWithoutImage(this);
	}
}
