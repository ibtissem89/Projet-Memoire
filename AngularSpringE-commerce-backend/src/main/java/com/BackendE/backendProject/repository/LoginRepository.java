package com.BackendE.backendProject.repository;

import com.BackendE.backendProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);
     Optional<User> findUserByUserEmail(String email);

}
