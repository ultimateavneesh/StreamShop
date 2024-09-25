package com.stream.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stream.shop.entity.Inventory;
import com.stream.shop.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public Inventory addInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	@Override
	public void deleteInventory(int id) {
		inventoryRepository.deleteById(id);
	}

	@Override
	public Inventory updateInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	@Override
	public Optional<Inventory> searchInventory(int id) {
		return inventoryRepository.findById(id);
	}

}
