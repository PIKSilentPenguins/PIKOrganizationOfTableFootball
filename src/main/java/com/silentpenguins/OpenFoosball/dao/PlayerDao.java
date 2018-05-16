package com.silentpenguins.OpenFoosball.dao;

import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Vector;

@Repository
public interface PlayerDao extends CrudRepository<Player,String> {


    Player findByUserName(String userName);

    Vector<Player> findAllByOrderByUserName();

    Vector<Player> findAllByOrderByPointsDesc();

}