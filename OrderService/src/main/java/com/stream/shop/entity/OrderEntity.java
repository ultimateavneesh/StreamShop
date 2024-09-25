package com.stream.shop.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class OrderEntity {

	@Id
	@GeneratedValue
	private int orderId;

	@OneToMany(targetEntity = LineItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_order", referencedColumnName = "orderId")
	private List<LineItem> lineItem;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<LineItem> getLineItem() {
		return lineItem;
	}

	public void setLineItem(List<LineItem> lineItem) {
		this.lineItem = lineItem;
	}

	public OrderEntity() {
		super();
	}

	public OrderEntity(int orderId, List<LineItem> lineItem) {
		super();
		this.orderId = orderId;
		this.lineItem = lineItem;
	}

}
