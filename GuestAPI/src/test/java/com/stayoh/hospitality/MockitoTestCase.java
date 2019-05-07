package com.stayoh.hospitality;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import com.stayoh.hospitality.controller.GuestController;
import com.stayoh.hospitality.entity.Guest;

@RunWith(MockitoJUnitRunner.class)
/* @WebMvcTest(GuestController.class) */
public class MockitoTestCase {
	
	
	 //@InjectMocks GuestController manager;
	 
	
	@Mock GuestController dao;
	
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	 @Test
	    public void getAllEmployeesTest()
	    {
		// List<Guest> list = new ArrayList<Guest>();
		 System.out.println("---------------------------------"+dao.findAllGuest());
		
		//  when(dao.findAllGuest());
		
		  List<Guest> empList = dao.findAllGuest();
		 
		  System.out.println(empList.size()+"---------------------------------"+dao.findAllGuest());
		 
		  assertEquals(6, empList.size());
		 
		 
	    }
}
