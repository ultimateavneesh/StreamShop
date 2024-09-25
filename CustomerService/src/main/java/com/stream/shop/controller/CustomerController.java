package com.stream.shop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stream.shop.entity.Customer;
import com.stream.shop.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
		return "Customer Deleted!";
	}

	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	@GetMapping("/searchCustomer/{id}")
	public Optional<Customer> searchCustomer(@PathVariable int id) {
		return customerService.searchCustomer(id);
	}

}
