package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.dao.PersonDao;
import com.silentpenguins.OpenFoosball.model.Person;
import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class RankingService {

    @Autowired
    PersonDao personDao;

    @Autowired
    MappingPersonToPlayerService mappingPersonToPlayerService;

    public Vector<Player> getAllOrederByPoints(){
        Vector<Person> persons = personDao.findAllByOrderByPointsDesc();
        Vector<Player> players = new Vector<>();
        for (Person p: persons ) {
            players.add(mappingPersonToPlayerService.map(p) );
        }
        return players;
    }
}
