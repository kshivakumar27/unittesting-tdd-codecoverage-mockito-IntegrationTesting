package com.JavaTesting.junittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.JavaTesting.junittesting.unittesting.data.SomeDataService;


class SomeDataServiceStub implements SomeDataService{
	
	@Override
	public int[] retrieveAllData() {		
		return new int[] {1,2,3};
	}


}
class SomeDataServiceStubEmpty implements SomeDataService{
	
	@Override
	public int[] retrieveAllData() {		
		return new int[] {0};
	}	

}
class SomeDataServiceStubOneValue implements SomeDataService{
	
	@Override
	public int[] retrieveAllData() {		
		return new int[] {5};
	}	

}


class SomeBusinessImplStubTest {

	
	@Test
	void calculateSumUSingDataservice_basic() {
		SomeBusinessImpl Business=new SomeBusinessImpl();
		Business.setSomeDataService(new SomeDataServiceStub());
		 int actualResult = Business.calculateSumUsingDataservice();
		 int expectedResult=6;
		 assertEquals(expectedResult,actualResult);
		 

	}
	
	
	@Test
	void calculateSumUSingDataservice_empty() {
		SomeBusinessImpl Business=new SomeBusinessImpl();
		Business.setSomeDataService(new SomeDataServiceStubEmpty());
		 int actualResult = Business.calculateSumUsingDataservice();
		 int expectedResult=0;
		 assertEquals(expectedResult,actualResult);
		 

	}
	
	@Test
	void calculateSumUSingDataservice_oneValue() {
		SomeBusinessImpl Business=new SomeBusinessImpl();
		Business.setSomeDataService(new SomeDataServiceStubOneValue());
		 int actualResult = Business.calculateSumUsingDataservice();
		 int expectedResult=5;
		 assertEquals(expectedResult,actualResult);
		 
	}


	
}


