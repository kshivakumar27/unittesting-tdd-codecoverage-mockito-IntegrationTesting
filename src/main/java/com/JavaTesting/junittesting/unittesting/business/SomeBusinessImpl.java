package com.JavaTesting.junittesting.unittesting.business;

import com.JavaTesting.junittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

	private SomeDataService someDataService;
	
	
	
	public SomeDataService getSomeDataService() {
		return someDataService;
	}

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		int sum=0;
		for(int value:data) {
			sum += value;
		}
		return sum;
	}
	
	public int calculateSumUsingDataservice() {
		int sum=0;
		int data[]=someDataService.retrieveAllData();
		for(int value:data) {
			sum += value;
		}
		return sum;
	}
	
	
	
}
