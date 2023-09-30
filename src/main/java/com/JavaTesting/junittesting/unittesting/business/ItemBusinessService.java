package com.JavaTesting.junittesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JavaTesting.junittesting.unittesting.data.ItemRepository;
import com.JavaTesting.junittesting.unittesting.model.Item;

@Component
public class ItemBusinessService {

	@Autowired
	private ItemRepository repository;
	
	public Item retreiveHardcodedItem() {
		System.out.println("hiiii");
		return new Item(1,"BAll",10,100);
	}

	public List<Item> retrieveAllItem(){
		
		List<Item> items= repository.findAll();
	
		for(Item  item:items) {
			item.setValue(item.getPrice()*item.getQuantity());
			
		}
		return items;
	}
	

}
