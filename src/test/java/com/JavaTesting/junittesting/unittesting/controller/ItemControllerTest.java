package com.JavaTesting.junittesting.unittesting.controller;



import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.JavaTesting.junittesting.unittesting.HelloWorldController;
import com.JavaTesting.junittesting.unittesting.business.ItemBusinessService;
import com.JavaTesting.junittesting.unittesting.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void helloWorld_basic() throws Exception{
		//call //"Hello-world"
		//verify Hello world
		RequestBuilder request= MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
//				.header("Content-type","application/json");
//				.accept(MediaType.Application_JSON);
		MvcResult result= mockMvc.perform(request)
//				.andExpect(status().isOk)
//				.andExpect(content().string("Hello world"))
				.andReturn();
		
		assertEquals("{\"name\":\"BAll\",\"id\":1,\"price\":10,\"quantity\":100}",result.getResponse().getContentAsString());
		
		
	}
	
	
	
	
	@Test
	public void itemFromBusinessService_basic() throws Exception{
		//call //"Hello-world"
		//verify Hello world
		when(businessService.retreiveHardcodedItem()).thenReturn(new Item(2,"BAT", 20, 200));
		
		RequestBuilder request= MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
//				.header("Content-type","application/json");
//				.accept(MediaType.Application_JSON);
		MvcResult result= mockMvc.perform(request)
//				.andExpect(status().isOk)
//				.andExpect(content().string("Hello world"))
				.andReturn();
		
		assertEquals("{\"name\":\"BAT\",\"id\":2,\"price\":20,\"quantity\":200}",result.getResponse().getContentAsString());
		
		
	}
	
	
	@Test
	public void retrieveAllItem_basic() throws Exception{
	
		when(businessService.retrieveAllItem()).thenReturn(
				Arrays.asList(new Item(2,"BAT", 20, 200),
				new Item(3,"BAT", 20, 200)));
		
		RequestBuilder request= MockMvcRequestBuilders
				.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		

		MvcResult result= mockMvc.perform(request)

				.andReturn();
		
		assertEquals("{\"id\":2,\\\"name\\\":\\\"BAT\\\",\"price\":20,\"quantity\":200},{\"id\\\":3,\\\"name\\\":\\\"BAT\\\",\\\"price\\\":20,\\\"quantity\\\":200}",result.getResponse().getContentAsString());
		
		
	}
	
	

}