package com.BackendE.backendProject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendE.backendProject.models.CartItem;
import com.BackendE.backendProject.models.User;

public interface CarteRepository extends JpaRepository<CartItem, Integer> {
    Optional<List<CartItem>> findByOwner(User user);
}
