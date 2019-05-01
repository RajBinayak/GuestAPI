package com.stayoh.hospitality.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roomId;
	
	@ManyToOne
	@JoinColumn(name = "hotelId")
	private Hotel hotelIdinRoom;
	
	private String roomType;
	
	private String roomNumber;
	
	
	@OneToMany(mappedBy="roomidInGuest", cascade = CascadeType.ALL)
	private List<Guest> guestList;

	
	
	public List<Guest> getGuestList() {
		return guestList;
	}

	public void setGuestList(List<Guest> guestList) {
		this.guestList = guestList;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	/*
	 * public Hotel getHotelIdinRoom() { return hotelIdinRoom; }
	 */

	public void setHotelIdinRoom(Hotel hotelIdinRoom) {
		this.hotelIdinRoom = hotelIdinRoom;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	

}
