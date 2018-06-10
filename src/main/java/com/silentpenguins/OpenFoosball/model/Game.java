package com.silentpenguins.OpenFoosball.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer leftScore;
    private Integer rightScore;


    @ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable( name = "game_right_users", joinColumns = {@JoinColumn(name = "game_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> rightTeam = new HashSet<>();


    @ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable( name = "game_left_users", joinColumns = {@JoinColumn(name = "game_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> leftTeam = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "scoring_id", nullable = false)
    private Scoring scoring;

    private Boolean confirmed;

    public Game() {}

    public Game(Integer leftScore, Integer rightScore, Set<User> rightTeam, Set<User> leftTeam, Scoring scoring, Boolean confirmed) {
        this.leftScore = leftScore;
        this.rightScore = rightScore;
        this.rightTeam = rightTeam;
        this.leftTeam = leftTeam;
        this.scoring = scoring;
        this.confirmed = confirmed;
    }

    public Set<User> getRightTeam() {
        return rightTeam;
    }

    public void setRightTeam(Set<User> rightTeam) {
        this.rightTeam = rightTeam;
    }

    public Set<User> getLeftTeam() {
        return leftTeam;
    }

    public void setLeftTeam(Set<User> leftTeam) {
        this.leftTeam = leftTeam;
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

    public Scoring getScoring() {
        return scoring;
    }

    public void setScoring(Scoring scoring) {
        this.scoring = scoring;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }
}
