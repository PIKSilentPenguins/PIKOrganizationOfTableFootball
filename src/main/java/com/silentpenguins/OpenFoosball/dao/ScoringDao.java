package com.silentpenguins.OpenFoosball.dao;

import com.silentpenguins.OpenFoosball.model.Person;
import com.silentpenguins.OpenFoosball.model.Scoring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Vector;

@Repository
public interface ScoringDao  extends CrudRepository<Scoring,Long> {
    Vector<Scoring> findAllByOrderByPoints();
}
