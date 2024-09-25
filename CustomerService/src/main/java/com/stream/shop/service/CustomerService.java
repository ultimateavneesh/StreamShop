package com.stream.shop.service;

import java.util.Optional;

import com.stream.shop.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	void deleteCustomer(int id);

	Customer updateCustomer(Customer customer);

	Optional<Customer> searchCustomer(int id);
	
}
