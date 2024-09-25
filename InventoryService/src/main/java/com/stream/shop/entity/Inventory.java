package com.stream.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Inventory {

	@Id
	@GeneratedValue
	private int inventoryId;
	private int productId;
	private int quantity;

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Inventory() {
		super();
	}

	public Inventory(int inventoryId, int productId, int quantity) {
		super();
		this.inventoryId = inventoryId;
		this.productId = productId;
		this.quantity = quantity;
	}

}
