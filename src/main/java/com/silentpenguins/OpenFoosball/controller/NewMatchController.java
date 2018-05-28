package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.NewMatchRQ;
import com.silentpenguins.OpenFoosball.pojo.Player;
import com.silentpenguins.OpenFoosball.service.LoginService;
import com.silentpenguins.OpenFoosball.service.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class NewMatchController {

    private static final Logger logger = Logger.getLogger(NewMatchController.class.getName());

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @RequestMapping("/new_match")
    public String showNewMatch(Map<String, Object> model, @RequestParam(value = "player", required = false) String requestedPlayerUsername) {
        Player logged_player = new Player();

        if (requestedPlayerUsername != null) {
            model.put("requested_player", requestedPlayerUsername);
        }

        Vector<Player> playerVector = this.userService.getAllPlayersOrderByUserName();
        Vector<String> usernameVector = new Vector<>();
        for(Player player : playerVector){
            usernameVector.add(player.getUserName());
        }
        model.put("username_vector", usernameVector);
        model.put("logged_player", loginService.getCurrentUserName());
        model.put("players_vector", userService.getAllPlayersOrderByUserName());

        return "new_match";
    }

    @PostMapping("/new_match/create_match")
    public Response createMatch(Map<String, Object> model, @RequestBody NewMatchRQ newMatchRQ) {
        logger.log(Level.WARNING, newMatchRQ.getPlayer_one_your_team() +
                newMatchRQ.getPlayer_two_your_team() +
                newMatchRQ.getPlayer_one_opponent_team() +
                newMatchRQ.getPlayer_two_opponen_team() +
                newMatchRQ.getCurrentTeamValue() +
                newMatchRQ.getOpponentTeamValue());
        return new Response();
    }
}
