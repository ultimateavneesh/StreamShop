package com.stream.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stream.shop.entity.CustomerCart;
import com.stream.shop.entity.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

	@Query(value = "select order_id, customer_id from customer_order where customer_id = ?", nativeQuery = true)
	List<CustomerOrder> findAllOrders(int customerId);

}
