package com.BackendE.backendProject.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    // User details
    private String username;
    private String userLastName;
    private String userEmail;
    private String userTel;
    private String password;
    private String userRole;
    private String userGenre;

    // One-to-Many relationship with CartItem
    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<CartItem> myCartItems;

    // Constructors

    // Constructor with all user details
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

    // Constructor with id, username, password, and userRole parameters
    public User(Integer id, String username, String password, String userRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    // Constructor with id, username, and password parameters
    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Constructor with username and password parameters
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Default constructor
    public User() {
    }

    // Getters and Setters

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

    public String getUserGenre() {
        return userGenre;
    }

    public void setUserGenre(String userGenre) {
        this.userGenre = userGenre;
    }

    public List<CartItem> getMyCartItems() {
        return myCartItems;
    }

    public void setMyCartItems(List<CartItem> myCartItems) {
        this.myCartItems = myCartItems;
    }

    // toString method for debugging and logging purposes
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
