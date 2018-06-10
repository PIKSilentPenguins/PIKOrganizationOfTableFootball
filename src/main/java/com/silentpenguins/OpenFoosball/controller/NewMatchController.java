package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.NewMatchRQ;
import com.silentpenguins.OpenFoosball.pojo.Player;
import com.silentpenguins.OpenFoosball.service.LoginService;
import com.silentpenguins.OpenFoosball.service.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
@RequestMapping("/new_match")
public class NewMatchController {

    private static final Logger logger = Logger.getLogger(NewMatchController.class.getName());

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @RequestMapping("")
    public String showNewMatch(Map<String, Object> model, @RequestParam(value = "player", required = false) String requestedPlayerUsername) {
        Player logged_player = new Player();

        if (requestedPlayerUsername != null) {
            model.put("requested_player", requestedPlayerUsername);
        }

        Vector<Player> playerVector = this.userService.getAllPlayersOrderByUserName();

        for(int i = 0 ; i <playerVector.size() ; ++i){
            if(playerVector.elementAt(i).getUserName().equals(loginService.getCurrentUserName()))
                model.put("logged_player", i);
            if(playerVector.elementAt(i).getUserName().equals(requestedPlayerUsername))
                model.put("requested_player",i);
        }
        model.put("players_vector", playerVector);

        return "new_match";
    }

    @PostMapping("/create_match")
    public Response createMatch(@RequestBody NewMatchRQ newMatchRQ) {
        logger.log(Level.WARNING, newMatchRQ.getPlayer_one_your_team() +
                newMatchRQ.getPlayer_two_your_team() +
                newMatchRQ.getPlayer_one_opponent_team() +
                newMatchRQ.getPlayer_two_opponen_team() +
                newMatchRQ.getCurrentTeamValue() +
                newMatchRQ.getOpponentTeamValue());

        return new Response();
    }
}
