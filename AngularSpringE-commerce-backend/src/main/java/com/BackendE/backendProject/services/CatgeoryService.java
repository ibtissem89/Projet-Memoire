package com.BackendE.backendProject.services;

import com.BackendE.backendProject.models.Category;
import com.BackendE.backendProject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatgeoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getallCategorys() {
        return this.categoryRepository.findAll();
    }
}
