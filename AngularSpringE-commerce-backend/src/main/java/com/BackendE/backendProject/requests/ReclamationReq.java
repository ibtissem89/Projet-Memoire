package com.BackendE.backendProject.requests;

public class ReclamationReq {
    private String nom;
    private String email;
    private String sujet;
    private String message;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public ReclamationReq(String nom, String email, String sujet, String message) {
        this.nom = nom;
        this.email = email;
        this.sujet = sujet;
        this.message = message;
    }
    public ReclamationReq() {
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSujet() {
        return sujet;
    }
    public void setSujet(String sujet) {
        this.sujet = sujet;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    } 
}
