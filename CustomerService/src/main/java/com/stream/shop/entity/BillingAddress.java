package com.stream.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BillingAddress {

	@Id
	@GeneratedValue
	private int addId;
	private int doorNo;
	private String streetName;
	private String city;
	private int pincode;

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public BillingAddress() {
		super();
	}

	public BillingAddress(int addId, int doorNo, String streetName, String city, int pincode) {
		super();
		this.addId = addId;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.city = city;
		this.pincode = pincode;
	}
}
