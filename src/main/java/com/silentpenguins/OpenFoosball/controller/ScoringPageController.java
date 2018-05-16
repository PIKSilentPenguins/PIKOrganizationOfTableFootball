package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.AwardedPoints;
import com.silentpenguins.OpenFoosball.service.ScoringPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Vector;

@Controller
public class ScoringPageController {

    @Autowired
    ScoringPageService scoringPageService;

    @RequestMapping("/scoring")
    public String showScoring(Map<String, Object> model) {

        //TODO setowanie z bazy
        /*
        Vector<AwardedPoints> pointsVector = new Vector<>();
        AwardedPoints trainingPoints = new AwardedPoints();
        trainingPoints.setId(1);
        trainingPoints.setName("Training Points");
        trainingPoints.setPoints(0);

        AwardedPoints regularPoints = new AwardedPoints();
        regularPoints.setId(2);
        regularPoints.setName("Regular Points");
        regularPoints.setPoints(1);

        AwardedPoints tournamentPoints = new AwardedPoints();
        tournamentPoints.setId(3);
        tournamentPoints.setName("Tournament Points");
        tournamentPoints.setPoints(3);

        pointsVector.add(trainingPoints);
        pointsVector.add(regularPoints);
        pointsVector.add(tournamentPoints);*/

        model.put("pointsVector", scoringPageService.getAllAwardedPoints());

        return "scoring";
    }

}

