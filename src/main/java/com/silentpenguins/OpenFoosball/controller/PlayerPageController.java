package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.Player;
import com.silentpenguins.OpenFoosball.service.LoginService;
import com.silentpenguins.OpenFoosball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PlayerPageController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @Value("${welcome.message:test}")
    private String message = "Hello World";


    @RequestMapping("/playerpage")
    public String showPlayerPage(Map<String, Object> model, @RequestParam(value="player", required=false) String requestedPlayerUsername) {
        model.put("message", this.message);

        Player requested_player;

        if(requestedPlayerUsername != null){
            requested_player = this.userService.getPlayerByName(requestedPlayerUsername);
        }
        else {
            requested_player = this.userService.getPlayerByName(loginService.getCurrentUserName());
        }

        model.put("player", requested_player);
        return "playerpage";


    }


}

