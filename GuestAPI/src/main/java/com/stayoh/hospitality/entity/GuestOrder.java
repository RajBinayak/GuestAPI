package com.stayoh.hospitality.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class GuestOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	
	@ManyToOne(fetch = FetchType.LAZY)//cascade= CascadeType.ALL)
	@JoinColumn(name="guestt")//,referencedColumnName="guestId")//, nullable=false)
	@JsonIgnore
	private Guest guest;
	
	@OneToMany(mappedBy="orderId",cascade= CascadeType.ALL)
	private List<Item> item;
	
	
	private int quantity;


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	  public void setGuest(Guest guestId) { this.guest = guestId; }
	 


	public List<Item> getItem() {
		return item;
	}


	public void setItem(List<Item> item) {
		this.item = item;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
