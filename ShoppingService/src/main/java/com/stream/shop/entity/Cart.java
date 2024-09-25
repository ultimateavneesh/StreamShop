package com.stream.shop.entity;

import java.util.List;

public class Cart {

	private int cartId;
	private List<LineItem> lineItem;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<LineItem> getLineItem() {
		return lineItem;
	}

	public void setLineItem(List<LineItem> lineItem) {
		this.lineItem = lineItem;
	}
}
