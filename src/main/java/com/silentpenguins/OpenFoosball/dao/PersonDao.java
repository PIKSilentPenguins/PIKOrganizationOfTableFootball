package com.silentpenguins.OpenFoosball.dao;

import com.silentpenguins.OpenFoosball.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao extends CrudRepository<Person,String> {
    List<Person> findByName(String name);
}
