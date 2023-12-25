package com.BackendE.backendProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendE.backendProject.models.Reclamation;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
    // Add custom query methods if needed
}
