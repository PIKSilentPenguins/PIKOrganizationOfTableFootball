package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.Match;
import com.silentpenguins.OpenFoosball.pojo.Player;
import com.silentpenguins.OpenFoosball.service.MatchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Vector;

@Controller
public class MatchHistoryController {

    @Autowired
    MatchHistoryService matchHistoryService;

    @RequestMapping("/match_history")
    public String showMatchHistory(Map<String, Object> model) {

        //TODO setowanie z bazy do matchVector. Należy wybrać tylko zalogowanego Usera - pewnie będzie Autowirowany :)
        /*Vector<Match> matchVector = new Vector<>();
        for(int i =0 ; i< 10 ; ++i){
            Match match1 = new Match();
            match1.setId(1+i*4); // Niech będzie setowany z bazy.

            Match match2 = new Match();
            match2.setId(2+i*4);
            match2.setWin(true);
            match2.setType("Tournament Match");
            match2.setLeftScore(5);
            match2.setRightScore(0);
            match2.setLeftTeam("Marcin Puc,Tom Olek");
            match2.setRightTeam("Wasiollo,Pointer");

            Match match3 = new Match();
            match3.setId(3+i*4);
            match3.setWin(false);
            match3.setType("Regular Match");
            match3.setLeftScore(3);
            match3.setRightScore(1);
            match3.setLeftTeam("Pointer,Tom Olek");
            match3.setRightTeam("Wasiollo,Marcin Puc");

            Match match4 = new Match();
            match4.setId(4+i*4);
            match4.setWin(true);
            match4.setType("Tournament Match");
            match4.setLeftScore(1);
            match4.setRightScore(7);
            match4.setLeftTeam("Rododendron,Tom Olek");
            match4.setRightTeam("Wasiollo,Marcin Puc");


            matchVector.add(match1);
            matchVector.add(match2);
            matchVector.add(match3);
            matchVector.add(match4);
        }
        model.put("matchVector", matchVector);*/

        Player loggedPlayer = new Player(); //TODO wyciagnac zalogowanego gracza ale nie wiem jak ;)
        model.put("matchVector", matchHistoryService.getAllMatchesByUserName(loggedPlayer.getUserName()));



        return "match_history";
    }
}
