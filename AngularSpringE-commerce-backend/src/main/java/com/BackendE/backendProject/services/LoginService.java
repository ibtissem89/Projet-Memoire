package com.BackendE.backendProject.services;

import com.BackendE.backendProject.models.User;
import com.BackendE.backendProject.repository.LoginRepository;
import com.BackendE.backendProject.requests.UserLogin;
import com.BackendE.backendProject.requests.UserRegister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginrepository;

    public User loginuser(UserLogin userLogin) {
        User userbyusername = loginrepository.findUserByUserEmail(userLogin.getUsername()).orElse(null);
        if (userbyusername == null) {

            throw new IllegalStateException("Username or password is wrong");
        } else {
            if (userbyusername.getPassword().equals(userLogin.getPassword())) {

                return userbyusername;
            } else {
                // password
                throw new IllegalStateException("Username or password is wrong");
            }
        }
    }

    public User getUserById(Integer id) {
        return loginrepository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        return loginrepository.findUserByUserEmail(email).orElse(null);
    }

    public User registerUser(UserRegister user) {
        return loginrepository
                .save(new User(user.getNom(), user.getPrénom(), user.getEmail(), user.getTél(), user.getMpass(),
                        user.getPrvilege(), user.getGenre()));
    }
}
