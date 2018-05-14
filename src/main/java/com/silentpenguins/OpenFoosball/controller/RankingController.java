package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Vector;

@Controller
public class RankingController {

    @RequestMapping("/ranking")
    public String showRanking(Map<String, Object> model) {
        Vector<Player> playerVector = new Vector<>();
        //TODO trzeba pobrać z bazy danych playerów i posortować i ch po punktach. i to wrzucić do playerVector.
        for(int i =0 ; i< 10 ; ++i){
            Player player1 = new Player();

            Player player2 = new Player();
            player2.setId(2);
            player2.setUserName("MPUC");
            player2.setFirstName("Martin");
            player2.setLastName("Putz");
            player2.setMatches(1000);
            player2.setPoints(10000);
            player2.setWins(150);

            Player player3 = new Player();
            player3.setId(3);
            player3.setUserName("Pointerrr");
            player3.setFirstName("Piotr");
            player3.setLastName("Komorowski");
            player3.setMatches(300);
            player3.setPoints(100);
            player3.setWins(100);

            Player player4 = new Player();
            player4.setId(3);
            player4.setUserName("Elo");
            player4.setFirstName("ELOELOELO");
            player4.setLastName("dlkamsdlasmdk");
            player4.setMatches(100);
            player4.setPoints(60);
            player4.setWins(100);


            playerVector.add(player1);
            playerVector.add(player2);
            playerVector.add(player3);
            playerVector.add(player4);
        }
        model.put("playerVector", playerVector);

        return "ranking";
    }
}
