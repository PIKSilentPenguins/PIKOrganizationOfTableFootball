package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.converters.GameToMatch;
import com.silentpenguins.OpenFoosball.dao.GameDao;
import com.silentpenguins.OpenFoosball.model.Game;
import com.silentpenguins.OpenFoosball.pojo.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Vector;

@Service
public class GameService {

    @Autowired
    GameDao gameDao;

    @Autowired
    GameToMatch gameToMatch;


    public Vector<Match> getAllMatchesByUserName(String userName) {
        Vector<Match> matches = gameToMatch.convertVector(gameDao.findByLeftTeam_UserNameAndConfirmed(userName,true));
        matches.addAll(gameToMatch.convertVector(gameDao.findByRightTeam_UserNameAndConfirmed(userName,true)));

        setMatchWin(matches, userName);

        return matches;
    }

    public Vector<Match> getMatchesToAccept(String userName){
        Vector<Match> matches = gameToMatch.convertVector(gameDao.findByRightTeam_UserNameAndConfirmed(userName, false));
        setMatchWin(matches, userName);
        return matches;
    }

    public void acceptMatch(long id){
        Optional<Game> game = gameDao.findById(id);
        if(game.isPresent()) {
            game.get().setConfirmed(true);
        }
        gameDao.save(game.get());
    }

    public void setMatchWin(Vector<Match> matches, String userName) {
        matches.forEach((m) -> {
            if(m.getLeftTeam().contains(userName)){
                if(m.getRightScore()  < m.getLeftScore())
                    m.setWin(true);
                else
                    m.setWin(false);
            }
            else {
                if(m.getRightScore()  < m.getLeftScore())
                    m.setWin(false);
                else
                    m.setWin(true);
            }
        });
    }
}
