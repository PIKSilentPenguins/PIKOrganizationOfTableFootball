package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class NewMatchController {

    @RequestMapping("/new_match")
    public String showNewMatch(Map<String, Object> model, @RequestParam(value="player", required=false) String requestedPlayerUsername) {
        Player logged_player = new Player();

        if (requestedPlayerUsername != null){
            Player requested_player = new Player();
            requested_player.setFirstName("Tom");
            requested_player.setLastName("Wally");
            requested_player.setWins(20);
            requested_player.setMatches(21);
            requested_player.setUserName(requestedPlayerUsername);
            requested_player.setPoints(20);
            model.put("requested_player", requested_player);

            //TODO zmodyfikować, żeby to było setowane z bazy w zależności od username :)
        }


        model.put("logged_player", logged_player);
        return "new_match";
    }
}
