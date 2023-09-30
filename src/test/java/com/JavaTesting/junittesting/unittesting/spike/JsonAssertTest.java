package com.JavaTesting.junittesting.unittesting.spike;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actualResponse="{\"name\":\"BAll\",\"id\":1,\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssert_strictTrue_ExactMAtch() throws JSONException {
		
		String expectedResponse= "{\"name\":\"BAll\",\"id\":1,\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
			
	}
	
	@Test
	public void jsonAssert_strictfalse_NotExactMAtch() throws JSONException {
		
		String expectedResponse= "{\"name\":\"BAT\",\"id\":1,\"price\":10900,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
			
	}
	
	@Test
	public void jsonAssert_withoutEscape() throws JSONException {
		
		String expectedResponse= "{name:BAT,id:1,price:10900,quantity:100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
			
	}

}
