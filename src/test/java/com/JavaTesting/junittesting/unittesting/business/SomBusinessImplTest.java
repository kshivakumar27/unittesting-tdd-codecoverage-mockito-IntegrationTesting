package com.JavaTesting.junittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomBusinessImplTest {

	@Test
	void calculateSum_basic() {
		SomeBusinessImpl Business=new SomeBusinessImpl();
		 int actualResult = Business.calculateSum(new int[] {1,2,3});
		 int expectedResult=6;
		 assertEquals(expectedResult,actualResult);
		 
		
//		fail("Not yet implemented");
	}
	@Test
	void calculateSum_empty() {
		SomeBusinessImpl Business=new SomeBusinessImpl();
		 int actualResult = Business.calculateSum(new int[] {});
		 int expectedResult=0;
		 assertEquals(expectedResult,actualResult);
	
	}
	@Test
	void calculateSum_oneValue() {
		SomeBusinessImpl Business=new SomeBusinessImpl();
		 int actualResult = Business.calculateSum(new int[] {5});
		 int expectedResult=5;
		 assertEquals(expectedResult,actualResult);
	
	}


}
