package com.silentpenguins.OpenFoosball.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Blob;
/*
@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    private String name;

    public Person(String name) {
        this.name = name;
    }
    protected Person() {}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}*/

@Entity
public class Person {
    private Integer id;
    @Id
    private String userName;
    private Blob profileImage;
    private String firstName;
    private String lastName;
    private Integer wins;
    private Integer matches;
    private Integer points;

    private Person(){}

    public Person(Integer id, String userName, Blob profileImage, String firstName, String lastName, Integer wins, Integer matches, Integer points) {
        this.id = id;
        this.userName = userName;
        this.profileImage = profileImage;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wins = wins;
        this.matches = matches;
        this.points = points;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Blob getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Blob profileImage) {
        this.profileImage = profileImage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}