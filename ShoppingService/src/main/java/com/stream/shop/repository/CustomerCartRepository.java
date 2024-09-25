package com.stream.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stream.shop.entity.CustomerCart;

public interface CustomerCartRepository extends JpaRepository<CustomerCart, Integer> {

}
