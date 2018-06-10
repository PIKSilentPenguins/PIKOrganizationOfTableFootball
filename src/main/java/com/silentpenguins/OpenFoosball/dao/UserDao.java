package com.silentpenguins.OpenFoosball.dao;

import com.silentpenguins.OpenFoosball.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Vector;

@Repository
public interface UserDao extends CrudRepository<User,Long> {

    User findByUserName(String userName);

    Vector<User> findAllByOrderByUserName();

    Vector<User> findAllByOrderByPointsDesc();

}
