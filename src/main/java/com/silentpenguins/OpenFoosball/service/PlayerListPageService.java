package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.dao.PlayerDao;
import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class PlayerListPageService {

    @Autowired
    PlayerDao playerDao;

    public Vector<Player> getAllPlayersOrderByUserName(){
        return playerDao.findAllByOrderByUserName();
    }

// Dla testowania
    void initData() {
            for(int i =0 ; i< 10 ; ++i){
                playerDao.save(new Player("mdo"+i, null, "Marcin", "Puc", 0, 10000, 0));
                playerDao.save(new Player("ptr"+i, null, "Piotr", "Komorowski", 50, 100, 150));
                playerDao.save(new Player("mati"+i, null, "Mateusz", "Plesinski", 10000, 10000, 10000000));
                playerDao.save(new Player("wasiollo"+i, null, "Mateusz", "Wasiak", 900, 1000, 2700));

            }



    }
}
