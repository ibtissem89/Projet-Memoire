package com.BackendE.backendProject.services;

import com.BackendE.backendProject.models.User;
import com.BackendE.backendProject.repository.LoginRepository;
import com.BackendE.backendProject.requests.UserLogin;
import com.BackendE.backendProject.responses.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginrepository;
    public Message loginuser(UserLogin userLogin) {
       User userbyusername = loginrepository.findUserByUsername(userLogin.getUsername()).orElse(null);
        if(userbyusername == null)
        {
            //username
            throw new IllegalStateException("Username or password is wrong");
        }
        else
        {
            if(userbyusername.getPassword().equals(userLogin.getPassword()))
            {

                    return new Message("Successful Login");
            }
            else
            {
                //password
                throw new IllegalStateException("Username or password is wrong");
            }
        }
    }
}
