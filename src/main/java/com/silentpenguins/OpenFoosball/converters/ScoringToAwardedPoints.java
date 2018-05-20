package com.silentpenguins.OpenFoosball.converters;

import com.silentpenguins.OpenFoosball.model.Scoring;
import com.silentpenguins.OpenFoosball.pojo.AwardedPoints;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Vector;

@Component
public class ScoringToAwardedPoints implements Converter<Scoring , AwardedPoints> {

    @Override
    public AwardedPoints convert(Scoring source) {
        AwardedPoints awardedPoints = new AwardedPoints();

        awardedPoints.setId(source.getId());
        awardedPoints.setImage(source.getImage());
        awardedPoints.setName(source.getName());
        awardedPoints.setPoints(source.getPoints());

        return awardedPoints;
    }

    public Vector<AwardedPoints> convertVector(Vector<Scoring> source){
        Vector<AwardedPoints> awardedPointsVector = new Vector<>();

        for (Scoring s: source) {
            awardedPointsVector.add(convert(s));
        }

        return awardedPointsVector;
    }

}
