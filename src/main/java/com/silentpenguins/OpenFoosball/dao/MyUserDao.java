package com.silentpenguins.OpenFoosball.dao;

import com.silentpenguins.OpenFoosball.model.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserDao extends CrudRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
