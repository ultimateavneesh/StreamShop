package com.stream.shop.intefaces;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stream.shop.entity.OrderEntity;

@FeignClient(name = "Order-Service", url = "http://localhost:8083/order")
public interface OrderRepository {

	@PostMapping("/cart")
	public OrderEntity addCart(@RequestBody OrderEntity orderEntity);

	@DeleteMapping("/cart/{id}")
	public String emptyCart(@PathVariable int id);

	@PutMapping("/cart")
	public OrderEntity updateCart(@RequestBody OrderEntity orderEntity);

	@GetMapping("/cart/{id}")
	public Optional<OrderEntity> searchCart(@PathVariable int id);
}
