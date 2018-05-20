package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.service.GameService;
import com.silentpenguins.OpenFoosball.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MatchHistoryController {

    @Autowired
    GameService gameService;

    @Autowired
    LoginService loginService;


    @RequestMapping("/match_history")
    public String showMatchHistory(Map<String, Object> model) {

        model.put("matchVector", gameService.getAllMatchesByUserName(loginService.getCurrentUserName()));

        return "match_history";
    }
}
