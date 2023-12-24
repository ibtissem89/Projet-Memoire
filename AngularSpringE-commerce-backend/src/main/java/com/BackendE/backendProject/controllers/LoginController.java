package com.BackendE.backendProject.controllers;

import com.BackendE.backendProject.models.User;
import com.BackendE.backendProject.requests.UserLogin;
import com.BackendE.backendProject.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public User login(@RequestBody UserLogin userLogin) {
        return loginService.loginuser(userLogin);
    }
}
