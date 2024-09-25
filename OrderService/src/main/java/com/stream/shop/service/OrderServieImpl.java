package com.stream.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stream.shop.entity.OrderEntity;
import com.stream.shop.repository.OrderRepository;

@Service
public class OrderServieImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public OrderEntity addCart(OrderEntity orderEntity) {
		return orderRepository.save(orderEntity);
	}

	@Override
	public void deleteCart(int id) {
		orderRepository.deleteById(id);
	}

	@Override
	public OrderEntity updateCart(OrderEntity orderEntity) {
		return orderRepository.save(orderEntity);
	}

	@Override
	public Optional<OrderEntity> searchCart(int id) {
		return orderRepository.findById(id);
	}

}
