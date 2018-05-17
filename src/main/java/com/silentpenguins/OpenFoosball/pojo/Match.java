package com.silentpenguins.OpenFoosball.pojo;

import java.util.Vector;

public class Match {
    private Integer id;
    private Integer leftScore;
    private Integer rightScore;
    private Vector<String> leftTeam;
    private Vector<String> rightTeam;
    private String type;
    private Boolean win; //Easier to handle on frontend :)
    private Boolean loggedInRightTeam;

    public Match(){
        setId(1);
        setLeftScore(3);
        setRightScore(2);
        setType("Training Match");
        setWin(true);
        setLeftTeam("MPUC,Marcin Puc");
        setRightTeam("Wasiollo,Pointerrr");
        setLoggedInRightTeam(true);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setLeftTeam(String leftTeam) {
        String[] team = leftTeam.split(",");
        if (team.length != 2)
            throw new IllegalArgumentException("String not in correct format");

        this.leftTeam = new Vector<>();
        this.leftTeam.add(team[0]);
        this.leftTeam.add(team[1]);
    }

    public Vector<String> getRightTeam() {
        return rightTeam;
    }

    public void setRightTeam(String rightTeam) {
        String[] team = rightTeam.split(",");
        this.rightTeam = new Vector<>();
        this.rightTeam.add(team[0]);
        this.rightTeam.add(team[1]);
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
