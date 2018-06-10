package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.converters.UserToPlayer;
import com.silentpenguins.OpenFoosball.dao.UserDao;
import com.silentpenguins.OpenFoosball.model.User;
import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserToPlayer userToPlayer;

    public Vector<Player> getAllPlayersOrderByUserName(){

        return userToPlayer.convertVector(userDao.findAllByOrderByUserName());
    }

    public Player getPlayerByName(String userName){

            User user = this.userDao.findByUserName(userName);
            if (user != null){
                return  userToPlayer.convert(user);
            }
            else {
                //TODO throw http resource not found error
                return new Player();
            }
    }

    public Vector<Player> getAllPlayersOrderByPoints(){
        return userToPlayer.convertVector(userDao.findAllByOrderByPointsDesc());
    }
}
