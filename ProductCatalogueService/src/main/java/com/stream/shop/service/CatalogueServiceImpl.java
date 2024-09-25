package com.stream.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stream.shop.entity.Product;
import com.stream.shop.repository.ProductRepository;

@Service
public class CatalogueServiceImpl implements CatalogueService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> serachProduct(int id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

}
