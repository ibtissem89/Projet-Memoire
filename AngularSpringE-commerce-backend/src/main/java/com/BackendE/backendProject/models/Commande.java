package com.BackendE.backendProject.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // List of order items associated with this order
    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    // Date when the order was placed
    private String orderDate;

    // Many-to-One relationship with the User entity (user who placed the order)
    @ManyToOne
    private User user;

    // Total amount of the order
    private double amount;

    // Order status (accepted / rejected)
    private String status;

    private String adressLivraison;

    // Default constructor
    public Commande() {
    }

    // Constructor with user, order items, and order date parameters
    public Commande(User user, List<OrderItem> orderItems, String orderDate) {
        this.user = user;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
    }
       // Constructor with user, order items, and order date parameters
    public Commande(User user, List<OrderItem> orderItems, String orderDate,String adressLivraison) {
        this.user = user;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.adressLivraison=adressLivraison;
    }

    // Constructor with id, order items, order date, and user parameters
    public Commande(Long id, List<OrderItem> orderItems, String orderDate, User user) {
        this.id = id;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.user = user;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getAdressLivraison() {
        return adressLivraison;
    }

    public void setAdressLivraison(String adressLivraison) {
        this.adressLivraison = adressLivraison;
    }

}
