package com.BackendE.backendProject.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.sql.Blob;

@Entity
public class Category {

    // Primary key for the Category entity
    @Id
    @GeneratedValue
    private Integer idCategory;

    private String name;

    // Number of products in the category
    private Integer nbProduct;

    // Large object field for storing image data
    @Lob
    @JsonSerialize(using = SqlBlobSerializer.class)
    private Blob image;

    // Constructors

    // Default constructor
    public Category() {
    }

    // Constructor with name, nbProduct, and image parameters
    public Category(String name, Integer nbProduct, Blob image) {
        this.name = name;
        this.nbProduct = nbProduct;
        this.image = image;
    }

    // Constructor with idCategory, name, nbProduct, and image parameters
    public Category(Integer idCategory, String name, Integer nbProduct, Blob image) {
        this.idCategory = idCategory;
        this.name = name;
        this.nbProduct = nbProduct;
        this.image = image;
    }

    // Getters and Setters

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNbProduct() {
        return nbProduct;
    }

    public void setNbProduct(Integer nbProduct) {
        this.nbProduct = nbProduct;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    // toString method for debugging and logging purposes
    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", name='" + name + '\'' +
                ", nbProduct=" + nbProduct +
                ", image=" + image +
                '}';
    }

}
