package com.stream.shop.service;

import java.util.Optional;

import com.stream.shop.entity.OrderEntity;

public interface OrderService {

	OrderEntity addCart(OrderEntity orderEntity);

	void deleteCart(int id);

	OrderEntity updateCart(OrderEntity orderEntity);

	Optional<OrderEntity> searchCart(int id);

}
