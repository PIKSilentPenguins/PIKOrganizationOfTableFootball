package com.silentpenguins.OpenFoosball.pojo;

import com.silentpenguins.OpenFoosball.model.User;

import java.util.Vector;


public class Match {
    private Long id;
    private Integer leftScore;
    private Integer rightScore;
    private Vector<String> leftTeam = new Vector<>();
    private Vector<String> rightTeam = new Vector<>();
    private String type;
    private Boolean win; //Easier to handle on frontend :)
    private Boolean loggedInRightTeam;

    public Match() {
    }

    public Match(Long id, Integer leftScore, Integer rightScore, Vector<String> leftTeam, Vector<String> rightTeam, String type, Boolean win) {
        this.id = id;
        this.leftScore = leftScore;
        this.rightScore = rightScore;
        this.leftTeam = leftTeam;
        this.rightTeam = rightTeam;
        this.type = type;
        this.win = win;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLeftScore() {
        return leftScore;
    }

    public void setLeftScore(Integer leftScore) {
        this.leftScore = leftScore;
    }

    public Integer getRightScore() {
        return rightScore;
    }

    public void setRightScore(Integer rightScore) {
        this.rightScore = rightScore;
    }

    public Vector<String> getLeftTeam() {
        return leftTeam;
    }

    public void setLeftTeam(Vector<User> leftTeam) {

        this.leftTeam.clear();
        this.leftTeam.add(leftTeam.get(0).getUserName());
        this.leftTeam.add(leftTeam.get(1).getUserName());
    }

    public Vector<String> getRightTeam() {
        return rightTeam;
    }

    public void setRightTeam(Vector<User> rightTeam) {

        this.rightTeam.clear();
        this.rightTeam.add(rightTeam.get(0).getUserName());
        this.rightTeam.add(rightTeam.get(1).getUserName());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    public Boolean isLoggedInRightTeam() {
        return loggedInRightTeam;
    }

    public void setLoggedInRightTeam(Boolean loggedInRightTeam) {
        this.loggedInRightTeam = loggedInRightTeam;
    }
}
