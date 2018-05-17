package com.silentpenguins.OpenFoosball.dao;

import com.silentpenguins.OpenFoosball.model.Person;
import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Vector;

@Repository
public interface PersonDao extends CrudRepository<Person,String> {

    Person findByUserName(String userName);


    Vector<Person> findAllByOrderByUserName();

    Vector<Person> findAllByOrderByPointsDesc();

}
