package com.BackendE.backendProject.repository;


import com.BackendE.backendProject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Integer> {
}
