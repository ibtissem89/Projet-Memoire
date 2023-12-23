package com.BackendE.backendProject.repository;

import com.BackendE.backendProject.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
