package com.stream.shop.service;

import java.util.Optional;

import com.stream.shop.entity.Cart;

public interface CartService {

	Cart addCart(Cart cart);

	void deleteCart(int id);

	Cart updateCart(Cart cart);

	Optional<Cart> searchCart(int id);

}
