package com.JavaTesting.junittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.JavaTesting.junittesting.unittesting.data.ItemRepository;
import com.JavaTesting.junittesting.unittesting.data.SomeDataService;
import com.JavaTesting.junittesting.unittesting.model.Item;

@RunWith(MockitoJUnitRunner.class)
class ItemBusniessServiceTest {
	
	@InjectMocks
	ItemBusinessService Business;
	
	@Mock
	ItemRepository repository;
	


	@Test
	void calculateSumUSingDataservice_basic() {
		

		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2,"BAT", 20, 200),
				new Item(3,"BAT", 20, 200)));
		
		List<Item> items=Business.retrieveAllItem();

		 assertEquals(100,items.get(0).getValue());
		 assertEquals(200,items.get(1).getValue());
	}
	
	


}
