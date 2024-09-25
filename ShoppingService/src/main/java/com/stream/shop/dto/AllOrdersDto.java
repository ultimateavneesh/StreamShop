package com.stream.shop.dto;

import java.util.List;
import java.util.Optional;

import com.stream.shop.entity.Customer;
import com.stream.shop.entity.OrderEntity;

public class AllOrdersDto {

	private Optional<Customer> customer;
	private List<OrderEntity> orderEntitie;

	public Optional<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Optional<Customer> customer) {
		this.customer = customer;
	}

	public List<OrderEntity> getOrderEntitie() {
		return orderEntitie;
	}

	public void setOrderEntitie(List<OrderEntity> orderEntitie) {
		this.orderEntitie = orderEntitie;
	}
}
