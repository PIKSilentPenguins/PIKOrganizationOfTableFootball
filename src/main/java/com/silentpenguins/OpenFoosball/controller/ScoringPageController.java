package com.silentpenguins.OpenFoosball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ScoringPageController {
    @RequestMapping("/scoring")
    public String showScoring(Map<String, Object> model) {
        Integer trainingPoints = 0;
        Integer regularPoints = 1;
        Integer tournamentPoints = 3;
        model.put("trainingPoints", trainingPoints);
        model.put("regularPoints", regularPoints);
        model.put("tournamentPoints", tournamentPoints);

        return "scoring";
    }

}

