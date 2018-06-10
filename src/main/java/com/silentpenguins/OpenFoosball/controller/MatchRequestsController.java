package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.Match;
import com.silentpenguins.OpenFoosball.service.GameService;
import com.silentpenguins.OpenFoosball.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/match_requests")
public class MatchRequestsController {

    @Autowired
    GameService gameService;

    @Autowired
    LoginService loginService;

    private static final Logger logger = Logger.getLogger(MatchRequestsController.class.getName());

    Vector<Match> matchVector = new Vector<>();

    @GetMapping("")
    @PostMapping("")
    public String showMatchRequests(Map<String, Object> model) {

        matchVector.clear();

        logger.log(Level.INFO, "match_request.html visited"); // TODO jakieś inne logi.

        matchVector = gameService.getMatchesToAccept(loginService.getCurrentUserName());
        model.put("matchVector", matchVector);

        return "match_requests";
    }

    @GetMapping("/accept_request/{acceptedMatch}")
    public String acceptMatch(Map<String, Object> model, HttpServletRequest req, @PathVariable String acceptedMatch) {

        if (acceptedMatch != null) {
            matchVector.removeIf(match -> Objects.equals(match.getId(), new Long(acceptedMatch)));
            gameService.acceptMatch(Long.parseLong(acceptedMatch));

        }
        model.put("matchVector", matchVector);
        return "match_requests";
    }
}
