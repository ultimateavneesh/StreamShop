package com.stream.shop.intefaces;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stream.shop.entity.Inventory;

@FeignClient(name = "Inventory-Service", url = "http://localhost:8085/inventory")
public interface InventoryRepository {

	@PostMapping("/inventory")
	public Inventory addInventory(@RequestBody Inventory inventory);

	@DeleteMapping("/inventory/{id}")
	public String deleteInventory(@PathVariable int id);

	@PutMapping("/inventory")
	public Inventory updateInventory(@RequestBody Inventory inventory);

	@GetMapping("/inventory/{id}")
	public Optional<Inventory> searchInventory(@PathVariable int id);
}
