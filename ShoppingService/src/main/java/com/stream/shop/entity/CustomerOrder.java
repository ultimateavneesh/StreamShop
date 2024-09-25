package com.stream.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerOrder {

	@Id
	private int orderId;
	private int customerId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public CustomerOrder() {
		super();
	}

	public CustomerOrder(int orderId, int customerId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
	}
}
