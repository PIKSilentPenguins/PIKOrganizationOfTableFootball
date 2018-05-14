package com.silentpenguins.OpenFoosball.dao;

import com.silentpenguins.OpenFoosball.model.Scoring;

import java.util.List;

public interface ScoringDao {
    public List<Scoring> findAll();
}
