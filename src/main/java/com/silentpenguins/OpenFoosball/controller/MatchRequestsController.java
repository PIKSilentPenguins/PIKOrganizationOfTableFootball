package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.pojo.Match;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/match_requests")
public class MatchRequestsController {
    private static final Logger logger = Logger.getLogger(MatchRequestsController.class.getName());

    Vector<Match> matchVector = new Vector<>();

    @GetMapping("")
    @PostMapping("")
    public String showMatchRequests(Map<String, Object> model) {

        System.out.println("ELO SHHOW MATCH REQUESTS");
        matchVector.clear();

        //TODO setowanie z bazy do matchVector. Należy wybrać tylko zalogowanego Usera - pewnie będzie Autowirowany :)
        //TODO get z bazy taki, by Match był do akceptacji. W przypadku parametru trzeba będzie dodać setowanie na bazie
        //TODO parametru, że już został zaakceptowany, wydaje mi sie, że nie powinno wgle to być tak robione, ale chwilowo
        //TODO niech będzie tak. - pewnie tak jak tu: https://spring.io/guides/tutorials/bookmarks/

        for(int i = 9 ; i>= 0 ; --i){
            Match match1 = new Match();
            match1.setId(4+i*4); // Niech będzie setowany z bazy.

            Match match2 = new Match();
            match2.setId(3+i*4);
            match2.setWin(true);
            match2.setType("Tournament Match");
            match2.setLeftScore(5);
            match2.setRightScore(0);
            match2.setLeftTeam("Marcin Puc,Tom Olek");
            match2.setRightTeam("Wasiollo,Pointer");

            Match match3 = new Match();
            match3.setId(2+i*4);
            match3.setWin(false);
            match3.setType("Regular Match");
            match3.setLeftScore(3);
            match3.setRightScore(1);
            match3.setLeftTeam("Pointer,Tom Olek");
            match3.setRightTeam("Wasiollo,Marcin Puc");
            match3.setLoggedInRightTeam(false);

            Match match4 = new Match();
            match4.setId(1+i*4);
            match4.setWin(true);
            match4.setType("Tournament Match");
            match4.setLeftScore(1);
            match4.setRightScore(7);
            match4.setLeftTeam("Rododendron,Tom Olek");
            match4.setRightTeam("Wasiollo,Marcin Puc");
            match4.setLoggedInRightTeam(false);

            Match match5 = new Match();
            match5.setId(1+i*4);
            match5.setWin(false);
            match5.setType("Tournament Match");
            match5.setLeftScore(1);
            match5.setRightScore(7);
            match5.setLeftTeam("Rododendron,Tom Olek");
            match5.setRightTeam("Wasiollo,Marcin Puc");
            match5.setLoggedInRightTeam(true);


            matchVector.add(match1);
            matchVector.add(match2);
            matchVector.add(match3);
            matchVector.add(match4);
            matchVector.add(match5);
        }
        logger.log(Level.INFO, "match_request.html visited"); // TODO jakieś inne logi.

        model.put("matchVector", matchVector);

        return "match_requests";
    }

    @GetMapping("/accept_request/{acceptedMatch}")
    public String acceptMatch(Map<String, Object> model, HttpServletRequest req, @PathVariable String acceptedMatch) {
        System.out.println(acceptedMatch);

        if (acceptedMatch != null) {
            matchVector.removeIf(match -> Objects.equals(match.getId(), new Integer(acceptedMatch)));
            System.out.println(matchVector.size());
        }
        model.put("matchVector", matchVector);
        return "match_requests";
    }
}
