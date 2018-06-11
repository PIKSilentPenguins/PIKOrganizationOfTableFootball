package com.silentpenguins.OpenFoosball.controller;


import com.silentpenguins.OpenFoosball.dao.UserDao;
import com.silentpenguins.OpenFoosball.model.User;
import com.silentpenguins.OpenFoosball.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public String showHome() {
        List<User> people = (List<User>) userDao.findAll();
        for(User p : people)
            System.out.println(p.toString());

        return "home";
    }

    /*		String result = "";

		for(Customer cust : repository.findAll()){
			result += cust.toString() + "<br>";
		}

		return result;*/
}
