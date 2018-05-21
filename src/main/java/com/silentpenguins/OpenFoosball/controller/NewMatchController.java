package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.Player;
import com.silentpenguins.OpenFoosball.service.LoginService;
import com.silentpenguins.OpenFoosball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class NewMatchController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @RequestMapping("/new_match")
    public String showNewMatch(Map<String, Object> model, @RequestParam(value = "player", required = false) String requestedPlayerUsername) {
        Player logged_player = new Player();

        if (requestedPlayerUsername != null) {
            model.put("requested_player", requestedPlayerUsername);
        } else {
            model.put("requested_player", "");
        }


        model.put("logged_player", loginService.getCurrentUserName());
        model.put("players_vector", userService.getAllPlayersOrderByUserName());

        return "new_match";
    }
}
