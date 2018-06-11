package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.converters.GameToMatch;
import com.silentpenguins.OpenFoosball.dao.GameDao;
import com.silentpenguins.OpenFoosball.model.Game;
import com.silentpenguins.OpenFoosball.model.User;
import com.silentpenguins.OpenFoosball.pojo.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
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
        matches.addAll(gameToMatch.convertVector(gameDao.findByLeftTeam_UserNameAndConfirmed(userName,false)));
        setMatchWin(matches, userName);
        return matches;
    }

    public void acceptMatch(long id){
        Optional<Game> game = gameDao.findById(id);
        if(game.isPresent()) {
            game.get().setConfirmed(true);
            calculatePoints(game.get());
        }
        gameDao.save(game.get());
    }

    public void declineMatch(long id){
        Optional<Game> game = gameDao.findById(id);
        if(game.isPresent()){
            gameDao.delete(game.get());
        }
    }

    public void setMatchWin(Vector<Match> matches, String userName) {
        matches.forEach((m) -> {
            if(m.getLeftTeam().contains(userName)){
                m.setLoggedInRightTeam(false);
                if(m.getRightScore()  < m.getLeftScore())
                    m.setWin(true);
                else
                    m.setWin(false);
            }
            else {
                m.setLoggedInRightTeam(true);
                if(m.getRightScore()  < m.getLeftScore())
                    m.setWin(false);
                else
                    m.setWin(true);
            }
        });
    }

    private void calculatePoints(Game game){
        int points = game.getScoring().getPoints();
        if(game.getLeftScore() > game.getRightScore()){
            updateWinningTeam(game.getLeftTeam(), points);
            updateLosingTeam(game.getRightTeam(), points);
        }
        else if ( game.getLeftScore() < game.getRightScore()){
            updateWinningTeam(game.getRightTeam(), points);
            updateLosingTeam(game.getLeftTeam(), points);
        }
        else {
            updateWinningTeam(game.getRightTeam(), points);
            updateWinningTeam(game.getLeftTeam(), points);
        }
    }

    private void updateWinningTeam(Set<User> winningTeam, int points){
        for ( User player : winningTeam ) {
            player.setPoints(player.getPoints() + points);
            player.setMatches(player.getMatches() + 1);
            player.setWins(player.getWins() + 1);
        }
    }

    private void updateLosingTeam(Set<User> losingTeam, int points){
        for ( User player : losingTeam ) {
            player.setPoints(player.getPoints() - points);
            player.setMatches(player.getMatches() + 1);
        }
    }
}
