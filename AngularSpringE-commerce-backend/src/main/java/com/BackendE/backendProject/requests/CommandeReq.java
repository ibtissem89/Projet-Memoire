package com.BackendE.backendProject.requests;

public class CommandeReq {
    private Long id;
    private Integer userId;
    private double amount;
    private String adressLivraison;

    public String getAdressLivraison() {
        return adressLivraison;
    }

 

    public void setAdressLivraison(String adressLivraison) {
        this.adressLivraison = adressLivraison;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public CommandeReq(Long id, Integer userId) {
        this.id = id;
        this.userId = userId;
    }

}
