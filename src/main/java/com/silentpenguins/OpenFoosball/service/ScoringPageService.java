package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.dao.AwardedPointsDao;
import com.silentpenguins.OpenFoosball.pojo.AwardedPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Vector;

@Service
public class ScoringPageService {

    @Autowired
    AwardedPointsDao awardedPointsDao;

    public Vector<AwardedPoints> getAllAwardedPoints(){
        return awardedPointsDao.findAllByOrderByPoints();
    }

    public void initScoring() {

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

        awardedPointsDao.save(trainingPoints);
        awardedPointsDao.save(regularPoints);
        awardedPointsDao.save(tournamentPoints);

    }
}
