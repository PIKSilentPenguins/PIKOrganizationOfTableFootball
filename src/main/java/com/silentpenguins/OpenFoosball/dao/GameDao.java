package com.silentpenguins.OpenFoosball.dao;

import com.silentpenguins.OpenFoosball.model.Game;
import com.silentpenguins.OpenFoosball.pojo.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Vector;

@Repository
public interface GameDao extends CrudRepository<Game, Long> {
    Vector<Game> findAll();
}
