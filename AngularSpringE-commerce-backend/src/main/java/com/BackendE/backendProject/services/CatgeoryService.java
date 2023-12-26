package com.BackendE.backendProject.services;

import com.BackendE.backendProject.models.Category;
import com.BackendE.backendProject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatgeoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getallCategorys() {
        return this.categoryRepository.findAll();
    }
        public Optional<Category> getCatogoryByName(String name) {
        return this.categoryRepository.findByName(name);
    }
}
