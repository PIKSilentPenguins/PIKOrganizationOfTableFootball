package com.silentpenguins.OpenFoosball.dao;

import com.silentpenguins.OpenFoosball.pojo.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Vector;

@Repository
public interface MatchDao extends CrudRepository<Match, Long> {

    //Vector<Match> findDistinctByLeftTeamContainingOrRightTeamContaining(String userName); //TODO nie wiem jak to napisac zeby tego vectora przefiltrowalo
    Vector<Match> findAll();

}
