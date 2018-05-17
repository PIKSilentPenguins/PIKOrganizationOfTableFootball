package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.dao.PersonDao;
import com.silentpenguins.OpenFoosball.model.Person;
import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerPageService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private  MappingPersonToPlayerService mappingPersonToPlayerService;


    public Player getPlayerByName(String userName){

        if( userName != null){
            Person person = this.personDao.findByUserName(userName);
            if (person != null){

                //Player player = modelMapper.map(person, Player.class);
                //Player player = new Player(person.getUserName(),person.getProfileImage(), person.getFirstName(), person.getLastName(), person.getWins(), person.getMatches(), person.getPoints());
                return  mappingPersonToPlayerService.map(person);
            }
            else {
                //TODO error
                return new Player();
            }

        }
        else{
            return new Player(); //TODO  error?
        }
    }
}
