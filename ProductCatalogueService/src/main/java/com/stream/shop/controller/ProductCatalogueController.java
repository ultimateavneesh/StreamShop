package com.stream.shop.controller;

import java.util.List;
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

import com.stream.shop.entity.Product;
import com.stream.shop.service.CatalogueService;

@RestController
@RequestMapping("/catalogue")
public class ProductCatalogueController {

	@Autowired
	CatalogueService catalogueService;

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return catalogueService.addProduct(product);
	}

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable int id) {
		catalogueService.deleteProduct(id);
		return "Product Deleted!";
	}

	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		return catalogueService.updateProduct(product);
	}

	@GetMapping("/product/{id}")
	public Optional<Product> searchProduct(@PathVariable int id) {
		return catalogueService.serachProduct(id);
	}

	@GetMapping("/allProducts")
	public List<Product> getAllProducts() {
		return catalogueService.getAllProducts();
	}

}
