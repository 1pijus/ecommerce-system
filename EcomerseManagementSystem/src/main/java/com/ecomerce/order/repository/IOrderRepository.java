package com.ecomerce.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.order.entity.Orders;

public interface IOrderRepository extends JpaRepository<Orders, Integer>{
    
}
