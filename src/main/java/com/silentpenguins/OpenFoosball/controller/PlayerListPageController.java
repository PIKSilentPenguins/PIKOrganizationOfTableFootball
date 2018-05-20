package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.Player;
import com.silentpenguins.OpenFoosball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Vector;

@Controller
public class PlayerListPageController {

    @Autowired
    UserService userService;

    @RequestMapping("/player_list")
    public String showPlayerList(Map<String, Object> model) {

        Vector<Player> playerVector = this.userService.getAllPlayersOrderByUserName();
        model.put("playerVector", playerVector);


        return "player_list";
    }
}
