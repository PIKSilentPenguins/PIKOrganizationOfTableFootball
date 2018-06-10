package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    HomeService homeService;

    @RequestMapping("/login")
    public String showLogin() {
//        homeService.initDataBase();

        return "login";
    }

}
