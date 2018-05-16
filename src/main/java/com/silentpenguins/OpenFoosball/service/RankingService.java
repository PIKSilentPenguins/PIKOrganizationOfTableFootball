package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.dao.PlayerDao;
import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class RankingService {

    @Autowired
    PlayerDao playerDao;

    public Vector<Player> getAllOrederByPoints(){
        return playerDao.findAllByOrderByPointsDesc();
    }
}
