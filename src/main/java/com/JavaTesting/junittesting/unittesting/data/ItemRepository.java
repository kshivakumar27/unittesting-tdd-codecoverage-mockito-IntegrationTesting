package com.JavaTesting.junittesting.unittesting.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JavaTesting.junittesting.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findAll();

}
