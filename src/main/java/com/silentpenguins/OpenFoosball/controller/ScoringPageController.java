package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.service.ScoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ScoringPageController {

    @Autowired
    ScoringService scoringService;

    @RequestMapping("/scoring")
    public String showScoring(Map<String, Object> model) {

        model.put("pointsVector", scoringService.getAllAwardedPoints());

        return "scoring";
    }

}

