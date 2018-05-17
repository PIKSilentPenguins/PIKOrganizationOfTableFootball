package com.silentpenguins.OpenFoosball.model;

import javax.persistence.*;
import java.util.Vector;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer leftScore;
    private Integer rightScore;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "person_username", nullable = false)
    private Person leftTeamPlayer1;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "person_username", nullable = false)
    private Person leftTeamPlayer3;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "person_username", nullable = false)
    private Person rightTeamPlayer1;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "person_username", nullable = false)
    private Person rightTeamPlayer2;

    //private String leftTeamPlayer1;
    //private String leftTeamPlayer2;
   // private String rightTeamPlayer1;
    //private String rightTeamPlayer2;
    private String type;
    private Boolean confirmed;

    public Game() {}

    public Game(Integer leftScore, Integer rightScore, Person leftTeamPlayer1, Person leftTeamPlayer3, Person rightTeamPlayer1, Person rightTeamPlayer2, String type, Boolean confirmed) {
        this.leftScore = leftScore;
        this.rightScore = rightScore;
        this.leftTeamPlayer1 = leftTeamPlayer1;
        this.leftTeamPlayer3 = leftTeamPlayer3;
        this.rightTeamPlayer1 = rightTeamPlayer1;
        this.rightTeamPlayer2 = rightTeamPlayer2;
        this.type = type;
        this.confirmed = confirmed;
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

    public Person getLeftTeamPlayer1() {
        return leftTeamPlayer1;
    }

    public void setLeftTeamPlayer1(Person leftTeamPlayer1) {
        this.leftTeamPlayer1 = leftTeamPlayer1;
    }

    public Person getLeftTeamPlayer3() {
        return leftTeamPlayer3;
    }

    public void setLeftTeamPlayer3(Person leftTeamPlayer3) {
        this.leftTeamPlayer3 = leftTeamPlayer3;
    }

    public Person getRightTeamPlayer1() {
        return rightTeamPlayer1;
    }

    public void setRightTeamPlayer1(Person rightTeamPlayer1) {
        this.rightTeamPlayer1 = rightTeamPlayer1;
    }

    public Person getRightTeamPlayer2() {
        return rightTeamPlayer2;
    }

    public void setRightTeamPlayer2(Person rightTeamPlayer2) {
        this.rightTeamPlayer2 = rightTeamPlayer2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }
}
