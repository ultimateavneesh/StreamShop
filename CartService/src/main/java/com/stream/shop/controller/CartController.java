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

import com.stream.shop.entity.Cart;
import com.stream.shop.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;

	@PostMapping("/cart")
	public Cart addCart(@RequestBody Cart cart) {
		return cartService.addCart(cart);
	}

	@DeleteMapping("/cart/{id}")
	public String deleteCart(@PathVariable int id) {
		cartService.deleteCart(id);
		return "Cart Deleted!";
	}

	@PutMapping("/cart")
	public Cart updateCart(@RequestBody Cart cart) {
		return cartService.updateCart(cart);
	}

	@GetMapping("cart/{id}")
	public Optional<Cart> searchCart(@PathVariable int id) {
		return cartService.searchCart(id);
	}
}
