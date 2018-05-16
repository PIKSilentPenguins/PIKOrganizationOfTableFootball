package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.dao.PlayerDao;
import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerPageService {

    @Autowired
    private PlayerDao playerDao;


    public Player getPlayerByName(String userName){

        if( userName != null){
            Player temp_player = this.playerDao.findByUserName(userName);
            if (temp_player != null)
                return temp_player;
            else {
                //TODO error
                return new Player();
            }

        }
        else{
            return new Player(); //TODO  error?
        }
    }
}
