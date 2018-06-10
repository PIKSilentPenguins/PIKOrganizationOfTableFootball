package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.converters.ScoringToAwardedPoints;
import com.silentpenguins.OpenFoosball.dao.ScoringDao;
import com.silentpenguins.OpenFoosball.model.Scoring;
import com.silentpenguins.OpenFoosball.pojo.AwardedPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class ScoringService {

    @Autowired
    ScoringToAwardedPoints scoringToAwardedPoints;

    @Autowired
    ScoringDao scoringDao;

    public Vector<AwardedPoints> getAllAwardedPoints(){
        return scoringToAwardedPoints.convertVector(scoringDao.findAllByOrderByPoints());
    }


}
