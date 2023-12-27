package com.BackendE.backendProject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {

    // Primary key for the OrderItem entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One relationship with the Product entity
    @ManyToOne
    private Product product;

    private int quantity;

    // Many-to-One relationship with the Commande (Order) entity
    @ManyToOne
    private Commande order;

    // Constructors

    // Constructor with all parameters, including the order and the id
    public OrderItem(Long id, Product product, int quantity, Commande order) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.order = order;
    }

    // Constructor with all parameters including the order
    public OrderItem(Product product, int quantity, Commande order) {
        this.product = product;
        this.quantity = quantity;
        this.order = order;
    }

    // Constructor with product and quantity only (order is not specified)
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Commande getOrder() {
        return order;
    }

    public void setOrder(Commande order) {
        this.order = order;
    }
}
