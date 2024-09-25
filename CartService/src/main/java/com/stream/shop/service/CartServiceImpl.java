package com.stream.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stream.shop.entity.Cart;
import com.stream.shop.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;

	@Override
	public Cart addCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public void deleteCart(int id) {
		cartRepository.deleteById(id);
	}

	@Override
	public Cart updateCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public Optional<Cart> searchCart(int id) {
		return cartRepository.findById(id);
	}

}
