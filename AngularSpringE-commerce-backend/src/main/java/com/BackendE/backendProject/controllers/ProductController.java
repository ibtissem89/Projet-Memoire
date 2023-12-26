package com.BackendE.backendProject.controllers;

import com.BackendE.backendProject.models.Product;
import com.BackendE.backendProject.requests.ProductReq;
import com.BackendE.backendProject.responses.Message;
import com.BackendE.backendProject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getallproducts")
    public List<Product> getProducts() {
        return productService.getallproducts();
    }

    @DeleteMapping("/deleteproduct/{id}")
    public Message deleteProduct(@PathVariable Integer id) {
        return this.productService.deleteProduct(id);
    }

    @GetMapping("/getproductbyid/{id}")
    public Product getproductbyid(@PathVariable Integer id) {
        return this.productService.getproductbyid(id);
    }

    @GetMapping("/getproductbyCategory/{categoryName}")
    public List<Product> getproductbyid(@PathVariable String categoryName) {
        return this.productService.getProductsByCategory(categoryName);
    }

    @PostMapping("/addproduct")
    public Message addproduct(@RequestBody ProductReq productReq) throws SQLException {
        return this.productService.addproduct(productReq);
    }

    @PutMapping("/updateproduct")
    public Message updateproduct(@RequestBody ProductReq productReq) throws SQLException {
        return this.productService.updateProduct(productReq);
    }

}
