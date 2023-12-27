package com.BackendE.backendProject.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

import java.sql.Blob;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer idProduct;

    private String name;

    private String prix;

    private String description;

    // Large object field for storing image data
    @Lob
    @JsonSerialize(using = SqlBlobSerializer.class)
    private Blob image;

    // Many-to-One relationship with the Category entity
    @ManyToOne
    private Category category;

    // Default constructor
    public Product() {
    }

    // Constructor with all parameters, including idProduct
    public Product(Integer idProduct, String name, String prix, Blob image, Category category, String description) {
        this.idProduct = idProduct;
        this.name = name;
        this.prix = prix;
        this.image = image;
        this.category = category;
        this.description = description;
    }

    // Constructor with all parameters, excluding idProduct (auto-generated)
    public Product(String name, String prix, Blob image, Category category, String description) {
        this.name = name;
        this.prix = prix;
        this.image = image;
        this.category = category;
        this.description = description;
    }

    // Getters and Setters

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString method for debugging and logging purposes
    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", prix='" + prix + '\'' +
                ", image='" + image + '\'' +
                ", category='" + category.getName() + '\'' +
                '}';
    }
}
