package com.silentpenguins.OpenFoosball.pojo;

import java.sql.Blob;


public class Player {
    private Integer id;
    private String userName;
    private Blob profileImage;
    private String firstName;
    private String lastName;
    private Integer wins;
    private Integer matches;
    private Integer points;

    public Player(){
        setId(1);
        setUserName("Marcin Puc");
        setFirstName("Marcin");
        setLastName("Puc");
        setWins(100);
        setMatches(300);
        setPoints(170);
    }

    public Player( String userName, Blob profileImage, String firstName, String lastName, Integer wins, Integer matches, Integer points) {
        this.userName = userName;
        this.profileImage = profileImage;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wins = wins;
        this.matches = matches;
        this.points = points;
    }

    public Blob getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Blob profileImage) {
        this.profileImage = profileImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
