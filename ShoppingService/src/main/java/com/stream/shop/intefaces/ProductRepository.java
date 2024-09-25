package com.stream.shop.intefaces;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stream.shop.entity.Product;

@FeignClient(name = "Product-Catalogue-Service", url = "http://localhost:8084/catalogue")
public interface ProductRepository {

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product);

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable int id);

	@GetMapping("/product/{id}")
	public Optional<Product> searchProduct(@PathVariable int id);

	@GetMapping("/allProducts")
	public List<Product> getAllProducts();
}
