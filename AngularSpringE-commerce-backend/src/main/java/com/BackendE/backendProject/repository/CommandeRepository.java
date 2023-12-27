package com.BackendE.backendProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendE.backendProject.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande,Long>{
    
}
