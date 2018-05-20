package com.silentpenguins.OpenFoosball.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public String getCurrentUserName(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();

    }
}
