package com.stream.shop.intefaces;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stream.shop.entity.Customer;

@FeignClient(name = "Customer-Service", url = "http://localhost:8082/customer")
public interface CustomerRepository {

	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer);

	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable int id);

	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer);

	@GetMapping("/searchCustomer/{id}")
	public Optional<Customer> searchCustomer(@PathVariable int id);
}
