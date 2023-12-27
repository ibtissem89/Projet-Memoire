package com.BackendE.backendProject.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {

    // Primary key for the CartItem entity
    @Id
    @GeneratedValue
    private Integer id;

    // Many-to-One relationship with the User entity (owner of the cart item)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "owner_id")
    private User owner;

    // Many-to-One relationship with the Product entity
    @ManyToOne
    private Product product;

    private int quantity;

    // Constructors

    // Default constructor
    public CartItem() {
    }

    // Constructor with all parameters
    public CartItem(User owner, Product product, int quantity) {
        this.owner = owner;
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
