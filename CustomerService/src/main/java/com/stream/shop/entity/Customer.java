package com.stream.shop.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	private String customerName;
	private String customerEmail;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_bill")
	private BillingAddress billingAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_ship")
	private ShippingAddress shippingAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Customer() {
		super();
	}

	public Customer(int id, String customerName, String customerEmail, BillingAddress billingAddress,
			ShippingAddress shippingAddress) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

}
