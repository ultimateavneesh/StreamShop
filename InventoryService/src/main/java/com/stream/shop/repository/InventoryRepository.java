package com.stream.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stream.shop.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

}
