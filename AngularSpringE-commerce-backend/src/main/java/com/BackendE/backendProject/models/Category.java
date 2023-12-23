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

    @Id
    @GeneratedValue
    private Integer idCategory;
    private String name;
    private Integer nbProduct;

    @Lob
    @JsonSerialize(using = SqlBlobSerializer.class)
    private Blob image;

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", name='" + name + '\'' +
                ", nbProduct=" + nbProduct +
                ", image=" + image +
                '}';
    }

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

    public Category(String name, Integer nbProduct, Blob image) {
        this.name = name;
        this.nbProduct = nbProduct;
        this.image = image;
    }

    public Category(Integer idCategory, String name, Integer nbProduct, Blob image) {
        this.idCategory = idCategory;
        this.name = name;
        this.nbProduct = nbProduct;
        this.image = image;
    }
}
