package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.model.Person;
import com.silentpenguins.OpenFoosball.pojo.Player;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MappingPersonToPlayerService {

    private ModelMapper modelMapper = new ModelMapper(); //to do configure this to Autowire

    public Player map(Person person){
        return modelMapper.map(person, Player.class);
    }
}
