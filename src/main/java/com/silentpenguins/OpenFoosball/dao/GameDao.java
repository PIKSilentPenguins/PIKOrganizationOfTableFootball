package com.silentpenguins.OpenFoosball.dao;

import com.silentpenguins.OpenFoosball.model.Game;
import com.silentpenguins.OpenFoosball.pojo.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Vector;

@Repository
public interface GameDao extends CrudRepository<Game, Long> {
    Vector<Game> findAll();
    Vector<Game> findByLeftTeam_UserName(String userName);
    Vector<Game> findByRightTeam_UserName(String userName);
    Vector<Game> findByLeftTeam_UserNameAndConfirmed(String userName, boolean confirmed);
    Vector<Game> findByRightTeam_UserNameAndConfirmed(String userName, boolean confirmed);
}
