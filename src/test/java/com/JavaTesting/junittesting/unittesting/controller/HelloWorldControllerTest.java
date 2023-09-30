package com.JavaTesting.junittesting.unittesting.controller;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.JavaTesting.junittesting.unittesting.HelloWorldController;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorld_basic() throws Exception{
		//call //"Hello-world"
		//verify Hello world
		RequestBuilder request= MockMvcRequestBuilders
				.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
		
//				.header("Content-type","application/json");
//				.accept(MediaType.Application_JSON);
		MvcResult result= mockMvc.perform(request)
//				.andExpect(status().isOk)
//				.andExpect(content().string("Hello world"))
				.andReturn();
		
		assertEquals("Hello World",result.getResponse().getContentAsString());
		
		
	}

}
