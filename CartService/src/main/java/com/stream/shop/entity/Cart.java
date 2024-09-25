package com.stream.shop.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private int cartId;
	@OneToMany(targetEntity = LineItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_cart", referencedColumnName = "cartId")
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

	public Cart() {
		super();
	}

	public Cart(int cartId, List<LineItem> lineItem) {
		super();
		this.cartId = cartId;
		this.lineItem = lineItem;
	}

}
