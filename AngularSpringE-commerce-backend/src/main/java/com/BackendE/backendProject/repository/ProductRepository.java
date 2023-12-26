package com.BackendE.backendProject.repository;


import com.BackendE.backendProject.models.Category;
import com.BackendE.backendProject.models.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Integer> {
    List<Product> findByCategory(Category c);
}
