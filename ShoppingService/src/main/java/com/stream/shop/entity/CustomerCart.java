package com.stream.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerCart {

	@Id
	private int customerId;
	private int cartId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public CustomerCart() {
		super();
	}

	public CustomerCart(int customerId, int cartId) {
		super();
		this.customerId = customerId;
		this.cartId = cartId;
	}
}
