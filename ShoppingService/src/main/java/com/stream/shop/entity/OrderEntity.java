package com.stream.shop.entity;

import java.util.List;

public class OrderEntity {

	private int orderId;
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
}
