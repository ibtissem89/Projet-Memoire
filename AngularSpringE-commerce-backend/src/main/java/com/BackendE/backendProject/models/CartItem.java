package com.BackendE.backendProject.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class CartItem {
    @Id
    @GeneratedValue
    private Integer id;

   @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    private Product product;

    private int quantity;

    public CartItem() {
    }

    public CartItem(User owner, Product product, int quantity) {
        this.owner = owner;
        this.product = product;
        this.quantity = quantity;
    }

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
