package com.stayoh.hospitality.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	
	private String itemName;
	private double price;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="orderr")//,referencedColumnName="orderId")//, nullable=false)
	private GuestOrder orderId;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/*
	 * public GuestOrder getOrderId() { return orderId; }
	 */

	public void setOrderId(GuestOrder orderId) {
		this.orderId = orderId;
	}

	
	
	


	

	
	
	
}
