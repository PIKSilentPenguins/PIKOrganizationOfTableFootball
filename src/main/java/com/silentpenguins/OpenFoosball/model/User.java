package com.silentpenguins.OpenFoosball.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column( unique = true)
    private String userName;

    private Blob profileImage;
    private String firstName;
    private String lastName;
    private Integer wins;
    private Integer matches;
    private Integer points;

    @ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "rightTeam")
    private Set<Game> rightGames = new HashSet<>();

    @ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "leftTeam")
    private Set<Game> leftGames = new HashSet<>();

    public User(){}

    public User(@NotNull String userName, Blob profileImage, String firstName, String lastName, Integer wins, Integer matches, Integer points, Set<Game> rightGames, Set<Game> leftGames) {
        this.userName = userName;
        this.profileImage = profileImage;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wins = wins;
        this.matches = matches;
        this.points = points;
        this.rightGames = rightGames;
        this.leftGames = leftGames;
    }

    public User(@NotNull String userName, Blob profileImage, String firstName, String lastName, Integer wins, Integer matches, Integer points) {
        this.userName = userName;
        this.profileImage = profileImage;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wins = wins;
        this.matches = matches;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<Game> getRightGames() {
        return rightGames;
    }

    public void setRightGames(Set<Game> rightGames) {
        this.rightGames = rightGames;
    }

    public Set<Game> getLeftGames() {
        return leftGames;
    }

    public void setLeftGames(Set<Game> leftGames) {
        this.leftGames = leftGames;
    }


}