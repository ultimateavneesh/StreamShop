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

import com.stream.shop.entity.OrderEntity;
import com.stream.shop.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/cart")
	public OrderEntity addCart(@RequestBody OrderEntity orderEntity) {
		return orderService.addCart(orderEntity);
	}

	@DeleteMapping("/cart/{id}")
	public String emptyCart(@PathVariable int id) {
		orderService.deleteCart(id);
		return "Cart Deleted!";
	}

	@PutMapping("/cart")
	public OrderEntity updateCart(@RequestBody OrderEntity orderEntity) {
		return orderService.updateCart(orderEntity);
	}

	@GetMapping("/cart/{id}")
	public Optional<OrderEntity> searchCart(@PathVariable int id) {
		return orderService.searchCart(id);
	}
}
