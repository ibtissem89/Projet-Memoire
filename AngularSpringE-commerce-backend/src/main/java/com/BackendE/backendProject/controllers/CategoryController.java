package com.BackendE.backendProject.controllers;

import com.BackendE.backendProject.models.Category;
import com.BackendE.backendProject.services.CatgeoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class CategoryController {

    @Autowired
    private CatgeoryService catgeoryService;

    @GetMapping("/allCategorys")
    public List<Category> getallCategorys()
    {
        return this.catgeoryService.getallCategorys();
    }

}
