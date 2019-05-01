package com.stayoh.hospitality.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hotelId;
	
	@OneToMany(mappedBy="hotelIdinGuest")
	private List<Guest> guestList;
	
	@OneToMany(mappedBy="hotelIdinRoom")
	private List<Room> roomList;
	
	private String hotelDetails;

	
	
	
	
	
	
	
	
	
	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public List<Guest> getGuestList() {
		return guestList;
	}

	public void setGuestList(List<Guest> guestList) {
		this.guestList = guestList;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public String getHotelDetails() {
		return hotelDetails;
	}

	public void setHotelDetails(String hotelDetails) {
		this.hotelDetails = hotelDetails;
	}
	
	

}
