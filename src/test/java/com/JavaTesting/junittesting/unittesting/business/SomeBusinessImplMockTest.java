package com.JavaTesting.junittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.JavaTesting.junittesting.unittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
class SomeBusinessImplMockTest {
	
	@InjectMocks
	SomeBusinessImpl Business=new SomeBusinessImpl();
	
	@Mock
	SomeDataService dataServiceMock= mock(SomeDataService.class);
	
//	@Before
//	public void before() {
//		Business.setSomeDataService(dataServiceMock);	
//	}

	@Test
	void calculateSumUSingDataservice_basic() {
		
//		SomeBusinessImpl Business=new SomeBusinessImpl();	
//		SomeDataService dataServiceMock =mock(SomeDataService.class);

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3});
		
		Business.setSomeDataService(dataServiceMock);
//		 int actualResult = Business.calculateSumUsingDataservice();
//		 int expectedResult=6;
//		 assertEquals(expectedResult,actualResult);
		 
		 assertEquals(6,Business.calculateSumUsingDataservice());
	}
	
	
	@Test
	void calculateSumUSingDataservice_empty() {
		
//		SomeBusinessImpl Business=new SomeBusinessImpl();
		
//		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		
		Business.setSomeDataService(dataServiceMock);
//		 int actualResult = Business.calculateSumUsingDataservice();
//		 int expectedResult=0;
//		 assertEquals(expectedResult,actualResult);
		 

		 assertEquals(0,Business.calculateSumUsingDataservice());
	}
	
	@Test
	void calculateSumUSingDataservice_oneValue() {
		
//		SomeBusinessImpl Business=new SomeBusinessImpl();
		
		
//		SomeDataService dataServiceMock= mock(SomeDataService.class);
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		Business.setSomeDataService(dataServiceMock);
//		 int actualResult = Business.calculateSumUsingDataservice();
//		 int expectedResult=5;
//		 assertEquals(expectedResult,actualResult);
		
		 assertEquals(5,Business.calculateSumUsingDataservice());
	}


}
