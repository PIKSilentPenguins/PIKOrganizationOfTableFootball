package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.AwardedPoints;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Vector;

@Controller
public class ScoringPageController {
    @RequestMapping("/scoring")
    public String showScoring(Map<String, Object> model) {
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
        pointsVector.add(tournamentPoints);

        model.put("pointsVector", pointsVector);

        /*Integer trainingPoints = 0;
        Integer regularPoints = 1;
        Integer tournamentPoints = 3;
        model.put("trainingPoints", trainingPoints);
        model.put("regularPoints", regularPoints);
        model.put("tournamentPoints", tournamentPoints);
        */
        return "scoring";
    }

}

