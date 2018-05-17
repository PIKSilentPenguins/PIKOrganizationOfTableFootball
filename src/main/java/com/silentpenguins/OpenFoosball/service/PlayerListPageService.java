package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.dao.PersonDao;
import com.silentpenguins.OpenFoosball.model.Person;
import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class PlayerListPageService {

    @Autowired
    PersonDao personDao;

    @Autowired
    MappingPersonToPlayerService mappingPersonToPlayerService;

    public Vector<Player> getAllPlayersOrderByUserName(){
        Vector<Person> persons = personDao.findAllByOrderByUserName();
        Vector<Player> players = new Vector<>();
        for (Person p: persons ) {
            players.add(mappingPersonToPlayerService.map(p) );
        }
        return players;
    }

// Dla testowania
    void initData() {
            for(int i =0 ; i< 10 ; ++i){
                personDao.save(new Person(1 + i,"mdo"+i, null, "Marcin", "Puc", 0, 10000, 0));
                personDao.save(new Person(2 + i,"ptr"+i, null, "Piotr", "Komorowski", 50, 100, 150));
                personDao.save(new Person(3 + i,"mati"+i, null, "Mateusz", "Plesinski", 10000, 10000, 10000000));
                personDao.save(new Person(4 + i,"wasiollo"+i, null, "Mateusz", "Wasiak", 900, 1000, 2700));

            }



    }
}
