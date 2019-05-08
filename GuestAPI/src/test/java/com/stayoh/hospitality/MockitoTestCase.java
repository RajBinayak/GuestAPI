package com.stayoh.hospitality;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class MockitoTestCase extends GuestApiApplicationTests {
	
	@Autowired private WebApplicationContext webApplicationContext;
	 private MockMvc mockMvc;
	 
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	   public void findAllEmployeesTest() throws Exception
	   {
		 
		mockMvc.perform(get("/api/guest/1")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.guestId").value(2))
		.andExpect(jsonPath("$.createdAt").value("2019-05-07"))
		.andExpect(jsonPath("$.updatedAt").value("2019-05-07"))
		//.andExpect(jsonPath("$.guestOrder").value("[]"))
		.andExpect(jsonPath("$.mobileNumber").value(12345))
		.andExpect(jsonPath("$.guectCode").value("bi123"))
		.andExpect(jsonPath("$.firstName").value("Binayak"))
		.andExpect(jsonPath("$.lastName").value("Pati"));
     // .andExpect(content().json("[{'createdAt':'2019-05-07','updatedAt':'2019-05-07','guestId':1,'firstName':'Binayak','lastName':'Pati','mobileNumber':12345,'guectCode':'bi123'}]"));
	   }
}
