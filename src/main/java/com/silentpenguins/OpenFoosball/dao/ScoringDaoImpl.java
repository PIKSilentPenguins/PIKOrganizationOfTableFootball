package com.silentpenguins.OpenFoosball.dao;

import com.silentpenguins.OpenFoosball.model.Scoring;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoringDaoImpl implements ScoringDao {

    @Override
    public List<Scoring> findAll() {
        return null;//TODO
    }
}
