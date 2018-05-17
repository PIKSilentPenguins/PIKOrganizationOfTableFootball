package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.dao.ScoringDao;
import com.silentpenguins.OpenFoosball.model.Scoring;
import com.silentpenguins.OpenFoosball.pojo.AwardedPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class ScoringPageService {

    @Autowired
    MappingScoringToAwardedPointsService mappingScoringToAwardedPointsService;

    @Autowired
    ScoringDao scoringDao;

    public Vector<AwardedPoints> getAllAwardedPoints(){
        Vector<Scoring> scorings = scoringDao.findAllByOrderByPoints();
        Vector<AwardedPoints> awardedPoints = new Vector<>();
        for (Scoring s: scorings) {
            awardedPoints.add(mappingScoringToAwardedPointsService.map(s));
        }
        return awardedPoints;
    }

    public void initScoring() {

        Scoring trainingPoints = new Scoring();
        trainingPoints.setId(1);
        trainingPoints.setName("Training Points");
        trainingPoints.setPoints(0);

        Scoring regularPoints = new Scoring();
        regularPoints.setId(2);
        regularPoints.setName("Regular Points");
        regularPoints.setPoints(1);

        Scoring tournamentPoints = new Scoring();
        tournamentPoints.setId(3);
        tournamentPoints.setName("Tournament Points");
        tournamentPoints.setPoints(3);

        scoringDao.save(trainingPoints);
        scoringDao.save(regularPoints);
        scoringDao.save(tournamentPoints);

    }
}
