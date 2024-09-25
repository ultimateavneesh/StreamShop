package com.stream.shop.intefaces;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stream.shop.entity.Cart;

@FeignClient(name = "Cart-Service", url = "http://localhost:8086/cart")
public interface CartRepository {

	@PostMapping("/cart")
	public Cart addCart(@RequestBody Cart cart);

	@DeleteMapping("/cart/{id}")
	public String deleteCart(@PathVariable int id);

	@PutMapping("/cart")
	public Cart updateCart(@RequestBody Cart cart);

	@GetMapping("cart/{id}")
	public Optional<Cart> searchCart(@PathVariable int id);

}
