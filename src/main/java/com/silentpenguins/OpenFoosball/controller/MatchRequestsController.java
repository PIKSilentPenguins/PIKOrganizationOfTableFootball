package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.Match;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Vector;

@Controller
public class MatchRequestsController {

    @RequestMapping("/match_requests")
    public String showMatchRequests(Map<String, Object> model, @RequestParam(value="acceppt", required=false) String accepptedMatch) {


        //TODO setowanie z bazy do matchVector. Należy wybrać tylko zalogowanego Usera - pewnie będzie Autowirowany :)
        //TODO get z bazy taki, by Match był do akceptacji. W przypadku parametru trzeba będzie dodać setowanie na bazie
        //TODO parametru, że już został zaakceptowany, wydaje mi sie, że nie powinno wgle to być tak robione, ale chwilowo
        //TODO niech będzie tak. - pewnie tak jak tu: https://spring.io/guides/tutorials/bookmarks/
        Vector<Match> matchVector = new Vector<>();
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
        if(accepptedMatch!=null) {
            matchVector.remove(new Integer(accepptedMatch) - 1);
            System.out.println(new Integer(accepptedMatch) - 1);
        }
        model.put("matchVector", matchVector);

        return "match_requests";
    }
}
