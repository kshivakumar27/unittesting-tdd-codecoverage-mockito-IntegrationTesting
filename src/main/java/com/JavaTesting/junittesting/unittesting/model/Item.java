package com.JavaTesting.junittesting.unittesting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Item {
	
	
	@Id
	private int id;
	private String name;
	private int price;
	private int quantity;
	
	@Transient
	private int value;
	
	protected Item() {
		
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Item(int id, String name, int price, int quantity) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", id=" + id + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
