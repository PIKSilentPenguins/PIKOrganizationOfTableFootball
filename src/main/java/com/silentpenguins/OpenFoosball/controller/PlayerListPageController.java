package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Vector;

@Controller
public class PlayerListPageController {

    @RequestMapping("/player_list")
    public String showPlayerList(Map<String, Object> model) {

        //TODO setowanie z bazy do playerVector. Należy posortować po username. :)
        Vector<Player> playerVector = new Vector<>();
        for(int i =0 ; i< 10 ; ++i){
            Player player1 = new Player();

            Player player2 = new Player();
            player2.setId(2);
            player2.setUserName("MPUC");
            player2.setFirstName("Martin");
            player2.setLastName("Putz");

            Player player3 = new Player();
            player3.setId(3);
            player3.setUserName("Pointerrr");
            player3.setFirstName("Piotr");
            player3.setLastName("Komorowski");

            Player player4 = new Player();
            player4.setId(4);
            player4.setUserName("Elo");
            player4.setFirstName("ELOELOELO");
            player4.setLastName("dlkamsdlasmdk");


            playerVector.add(player1);
            playerVector.add(player2);
            playerVector.add(player3);
            playerVector.add(player4);
        }
        model.put("playerVector", playerVector);

        return "player_list";
    }
}
