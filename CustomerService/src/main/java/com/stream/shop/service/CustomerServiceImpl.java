
package com.stream.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stream.shop.entity.Customer;
import com.stream.shop.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> searchCustomer(int id) {
		return customerRepository.findById(id);
	}

}
