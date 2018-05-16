package com.silentpenguins.OpenFoosball.dao;

import com.silentpenguins.OpenFoosball.pojo.AwardedPoints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Vector;

@Repository
public interface AwardedPointsDao extends CrudRepository<AwardedPoints,Long> {

    Vector<AwardedPoints> findAllByOrderByPoints();
}
