package com.stream.shop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stream.shop.entity.Inventory;
import com.stream.shop.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

	@PostMapping("/inventory")
	public Inventory addInventory(@RequestBody Inventory inventory) {
		return inventoryService.addInventory(inventory);
	}

	@DeleteMapping("/inventory/{id}")
	public String deleteInventory(@PathVariable int id) {
		inventoryService.deleteInventory(id);
		return "Inventory Deleted!";
	}

	@PutMapping("/inventory")
	public Inventory updateInventory(@RequestBody Inventory inventory) {
		return inventoryService.updateInventory(inventory);
	}

	@GetMapping("/inventory/{id}")
	public Optional<Inventory> searchInventory(@PathVariable int id) {
		return inventoryService.searchInventory(id);
	}
}
