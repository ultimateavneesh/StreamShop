package com.stream.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.stream.shop.entity.Product;

public interface CatalogueService {

	Product addProduct(Product product);

	void deleteProduct(int id);

	Product updateProduct(Product product);

	Optional<Product> serachProduct(int id);

	List<Product> getAllProducts();

}
