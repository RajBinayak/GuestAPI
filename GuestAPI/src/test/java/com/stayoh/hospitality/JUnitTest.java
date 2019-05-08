package com.stayoh.hospitality;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.stayoh.hospitality.entity.Guest;
import com.stayoh.hospitality.gateway.GuestGatewaySql;
import com.stayoh.hospitality.usecase.GuestUsecaseImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class JUnitTest {
	
	@Mock GuestGatewaySql guestGateway;
	
	@InjectMocks GuestUsecaseImpl useCase;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAllGuestSuccess()
	{
		List<Guest> guestList = new ArrayList<Guest>();
		Guest empOne = new Guest(1, "John","a");
		Guest empTwo = new Guest(2, "Alex","b");
		guestList.add(empOne);
		guestList.add(empTwo);
		when(guestGateway.findAll()).thenReturn(guestList);
		List<Guest> result = useCase.findAll();
		assertEquals(2, result.size());
	}
	
	@Test
	public void testGuestByIdSuccess()
	{
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		Guest empOne = new Guest(1, "Lokesh","Das");
		guestList.add(empOne);
		
		Optional<Guest> result = guestGateway.findById(1);
		when(guestGateway.findById(1)).thenReturn(result);
		
		assertEquals("Lokesh", empOne.getFirstName());
		assertEquals("Das", empOne.getLastName());
		
	}
	
	@Test
	public void testGuestSaveSuccess()
	{
		Guest empOne = new Guest(1, "Lokesh","Das");
		useCase.save(empOne);
		verify(guestGateway, times(1)).save(empOne);
		assertThat(empOne.getFirstName()).isNotNull();
	}
	
	@Test
	public void testGuestUpdateSuccess()
	{
		
		Guest empOne = new Guest(1, "Lokesh","Das");
		useCase.update(empOne);
		verify(guestGateway, times(1)).update(empOne);
		assertEquals("Lokesh",empOne.getFirstName());
	}
	
	@Test
	public void testGuestDeleteSuccess()
	{
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		Guest empOne = new Guest(1, "Lokesh","Das");
		guestList.add(empOne);
		
		String result = guestGateway.delete(1);
		when(guestGateway.delete(1)).thenReturn(result);
		
		assertEquals(null, result);
		
		
		
	}
	

}























