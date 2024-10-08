package com.stream.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stream.shop.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
