package com.stream.shop.service;

import java.util.Optional;

import com.stream.shop.entity.Inventory;

public interface InventoryService {

	Inventory addInventory(Inventory inventory);

	void deleteInventory(int id);

	Inventory updateInventory(Inventory inventory);

	Optional<Inventory> searchInventory(int id);

}
