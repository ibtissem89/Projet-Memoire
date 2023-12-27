package com.BackendE.backendProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendE.backendProject.models.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{
    
}
