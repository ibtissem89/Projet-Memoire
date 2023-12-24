package com.BackendE.backendProject.services;

import com.BackendE.backendProject.models.User;
import com.BackendE.backendProject.repository.LoginRepository;
import com.BackendE.backendProject.requests.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginrepository;

    public User loginuser(UserLogin userLogin) {
        User userbyusername = loginrepository.findUserByUsername(userLogin.getUsername()).orElse(null);
        if (userbyusername == null) {
            // username
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
    public User getUserById(Integer id){
       return loginrepository.findById(id).orElse(null);
    }
}
