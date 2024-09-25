package com.stream.shop.entity;

public class Product {
	private int productId;
	private String productname;
	private String prodcutDescription;
	private int productPrice;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProdcutDescription() {
		return prodcutDescription;
	}

	public void setProdcutDescription(String prodcutDescription) {
		this.prodcutDescription = prodcutDescription;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
}
