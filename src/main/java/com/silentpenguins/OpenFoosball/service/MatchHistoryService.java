package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.dao.MatchDao;
import com.silentpenguins.OpenFoosball.pojo.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class MatchHistoryService {

    @Autowired
    MatchDao matchDao;

    public Vector<Match> getAllMatchesByUserName(String userName) {
        //return matchDao.findDistinctByLeftTeamContainingOrRightTeamContaining(userName);
        return matchDao.findAll();
    }

    public void initData() {
        Match match1 = new Match();


        Match match2 = new Match();

        match2.setWin(true);
        match2.setType("Tournament Match");
        match2.setLeftScore(5);
        match2.setRightScore(0);
        match2.setLeftTeam("Marcin Puc,Tom Olek");
        match2.setRightTeam("Wasiollo,Pointer");

        Match match3 = new Match();

        match3.setWin(false);
        match3.setType("Regular Match");
        match3.setLeftScore(3);
        match3.setRightScore(1);
        match3.setLeftTeam("Pointer,Tom Olek");
        match3.setRightTeam("Wasiollo,Marcin Puc");

        Match match4 = new Match();

        match4.setWin(true);
        match4.setType("Tournament Match");
        match4.setLeftScore(1);
        match4.setRightScore(7);
        match4.setLeftTeam("Rododendron,Tom Olek");
        match4.setRightTeam("Wasiollo,Marcin Puc");

        Match match5 = new Match();

        match5.setWin(true);
        match5.setType("Tournament Match");
        match5.setLeftScore(100);
        match5.setRightScore(0);
        match5.setLeftTeam("Mateusz,Plesinski");
        match5.setRightTeam("Ptr,Marcin Puc");

        matchDao.save(match1);
        matchDao.save(match2);
        matchDao.save(match3);
        matchDao.save(match4);
        matchDao.save(match5);

    }
}
