package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.model.Person;
import com.silentpenguins.OpenFoosball.model.Scoring;
import com.silentpenguins.OpenFoosball.pojo.AwardedPoints;
import com.silentpenguins.OpenFoosball.pojo.Player;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MappingScoringToAwardedPointsService {


    private ModelMapper modelMapper = new ModelMapper(); //to do configure this to Autowire

    public AwardedPoints map(Scoring scoring){
        return modelMapper.map(scoring, AwardedPoints.class);
    }
}
