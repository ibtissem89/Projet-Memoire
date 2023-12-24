package com.BackendE.backendProject.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.sql.Blob;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer idProduct;
    private String name;
    private String prix;
    @Lob
    @JsonSerialize(using = SqlBlobSerializer.class)
    private Blob image;
    private String type;

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", prix='" + prix + '\'' +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Product() {
    }

    public Product(Integer idProduct, String name, String prix, Blob image, String type) {
        this.idProduct = idProduct;
        this.name = name;
        this.prix = prix;
        this.image = image;
        this.type = type;
    }

    public Product(String name, String prix, Blob image, String type) {
        this.name = name;
        this.prix = prix;
        this.image = image;
        this.type = type;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
