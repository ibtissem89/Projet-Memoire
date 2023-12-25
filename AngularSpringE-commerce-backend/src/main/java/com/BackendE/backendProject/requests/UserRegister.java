package com.BackendE.backendProject.requests;

public class UserRegister {
    private String nom;
    private String prénom;
    private String email;
    private String tél;
    private String mpass;
    private String genre;
    
    public UserRegister() {
    }
    public UserRegister(String nom, String prénom, String email, String tél, String mpass, String genre,
            String prvilege) {
        this.nom = nom;
        this.prénom = prénom;
        this.email = email;
        this.tél = tél;
        this.mpass = mpass;
        this.genre = genre;
        this.prvilege = prvilege;
    }
    private String prvilege;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrénom() {
        return prénom;
    }
    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTél() {
        return tél;
    }
    public void setTél(String tél) {
        this.tél = tél;
    }
    public String getMpass() {
        return mpass;
    }
    public void setMpass(String mpass) {
        this.mpass = mpass;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getPrvilege() {
        return prvilege;
    }
    public void setPrvilege(String prvilege) {
        this.prvilege = prvilege;
    }
}
