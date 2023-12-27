package com.BackendE.backendProject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reclamation {

    // Primary key for the Reclamation entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String description;

 
    private String user;

    // Creation date of the reclamation
    private String creationDate;

    // Default constructor
    public Reclamation() {
    }

    // Constructor with subject, description, user, and creationDate parameters
    public Reclamation(String subject, String description, String user, String creationDate) {
        this.subject = subject;
        this.description = description;
        this.user = user;
        this.creationDate = creationDate;
    }

    // Constructor with id, subject, description, and user parameters
    public Reclamation(Long id, String subject, String description, String user) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.user = user;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
