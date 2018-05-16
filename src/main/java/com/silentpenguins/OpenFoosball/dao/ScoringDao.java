package com.silentpenguins.OpenFoosball.dao;

import com.silentpenguins.OpenFoosball.model.Scoring;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoringDao {
    public List<Scoring> findAll();
}
