package com.stayoh.hospitality.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.stayoh.hospitality.entity.Guest;
import com.stayoh.hospitality.entity.Hotel;
import com.stayoh.hospitality.repository.HotelJpa;
import com.stayoh.hospitality.usecase.GuestUsecaseImpl;

@RestController
@RequestMapping("/api")
public class GuestController {
	@Autowired GuestUsecaseImpl guestImpl;
	@Autowired HotelJpa jpa;
	
	
	@PostMapping("/guest")
	public Guest createGuest(@RequestBody Guest guest)
	{
		return guestImpl.save(guest);
	}
	@GetMapping("/guest/hotel")
	public List<Hotel> find()
	{
		
		return jpa.findAll();
	}
	
	@GetMapping("/guest")
	public List<Guest> findAllGuest()
	{
		return guestImpl.findAll();
	}
	
	@GetMapping("/guest/{id}")
	public Optional<Guest> findOneGuest(@PathVariable("id") Integer id)
	{
		return guestImpl.findById(id);
	}
	
	@PutMapping("/guest/{id}")
	public Guest updateGuest(@PathVariable("id") Integer id,@RequestBody Guest guest)
	{
		Guest note = guestImpl.findById(id).orElseThrow(() -> new ResourceAccessException("not found"));
		
			//note.setName(guest.getName());
			note.setMobileNumber(guest.getMobileNumber());				
		
		return guestImpl.update(note);
	}
	
	@DeleteMapping("/guest/{id}")
	public void deleteGuest(@PathVariable("id") Integer gid)
	{
		guestImpl.delete(gid);
	}

}
