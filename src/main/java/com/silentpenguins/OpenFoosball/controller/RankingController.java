package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class RankingController {

    @Autowired
    UserService userService;

    @RequestMapping("/ranking")
    public String showRanking(Map<String, Object> model) {

        model.put("playerVector", userService.getAllPlayersOrderByPoints());

        return "ranking";
    }
}
