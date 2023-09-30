package com.JavaTesting.junittesting.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JavaTesting.junittesting.unittesting.business.ItemBusinessService;
import com.JavaTesting.junittesting.unittesting.model.Item;


@RestController
public class ItemController {
	
	@Autowired(required = false)
	private ItemBusinessService  businessService;
	
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1,"BAll",10,100);
		
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		return businessService.retreiveHardcodedItem();
		
	}
	
	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItem(){
		return businessService.retrieveAllItem();
	}



}
