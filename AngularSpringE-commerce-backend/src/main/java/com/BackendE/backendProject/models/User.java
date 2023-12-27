package com.BackendE.backendProject.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String userLastName;
    private String userEmail;
    private String userTel;
    private String password;
    private String userRole;
    private String userGenre;

    // One-to-Many relationship with Reclamation
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reclamation> reclamations;
    
    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<CartItem> myCartItems;

    public User(String username, String userLastName, String userEmail, String userTel, String password,
            String userRole, String userGenre) {
        this.username = username;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userTel = userTel;
        this.password = password;
        this.userRole = userRole;
        this.userGenre = userGenre;
    }

    public User(Integer id, String username, String userLastName, String userEmail, String userTel, String password,
            String userRole, String userGenre) {
        this.id = id;
        this.username = username;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userTel = userTel;
        this.password = password;
        this.userRole = userRole;
        this.userGenre = userGenre;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserGenre() {
        return userGenre;
    }

    public void setUserGenre(String userGenre) {
        this.userGenre = userGenre;
    }

    public User(Integer id, String username, String password, String userRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
