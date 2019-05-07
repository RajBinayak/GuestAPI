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
import javax.persistence.Table;

import org.springframework.stereotype.Service;

@Entity
@Table(name = "guest")
public class Guest extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int guestId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hotelId")
	private Hotel hotelIdinGuest;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="roomId")
	private Room roomidInGuest;
	
	@OneToMany(cascade= CascadeType.ALL,mappedBy="guest", fetch = FetchType.LAZY)
	private List<GuestOrder> guestOrder;
	
	private String firstName;
	private String lastName;
	//private String roomNumber;
	private Number mobileNumber;
	private String guectCode;
	//private Date checkInDate;
	//private Date checkOutDate;
	
	
	public Guest()
	{}
	public Guest(int i, String firstName, String lastName) {
		this.guestId = i;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	/*
	 * public Hotel getHotelIdinGuest() { return hotelIdinGuest; }
	 */
	public void setHotelIdinGuest(Hotel hotelIdinGuest) {
		this.hotelIdinGuest = hotelIdinGuest;
	}
	
	/*
	 * public Room getRoomidInGuest() { return roomidInGuest; }
	 */
	public void setRoomidInGuest(Room roomidInGuest) {
		this.roomidInGuest = roomidInGuest;
	}
	public List<GuestOrder> getGuestOrder() {
		return guestOrder;
	}
	public void setGuestOrder(List<GuestOrder> guestOrder) {
		this.guestOrder = guestOrder;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Number getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Number mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGuectCode() {
		return guectCode;
	}
	public void setGuectCode(String guectCode) {
		this.guectCode = guectCode;
	}
	
	
	
	
	
	
	
	

}
