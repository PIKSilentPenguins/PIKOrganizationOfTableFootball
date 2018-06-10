package com.silentpenguins.OpenFoosball.pojo;

public class NewMatchRQ {
    private String player_one_your_team;
    private String player_two_your_team;
    private String player_one_opponent_team;
    private String player_two_opponen_team;
    private Integer currentTeamValue;
    private Integer opponentTeamValue;

    public NewMatchRQ(){}

    public NewMatchRQ(String player_one_your_team, String player_two_your_team, String player_one_opponent_team, String player_two_opponen_team, Integer currentTeamValue, Integer opponentTeamValue){
        this.player_one_your_team = player_one_your_team;
        this.player_two_your_team = player_two_your_team;
        this.player_one_opponent_team = player_one_opponent_team;
        this.player_two_opponen_team =player_two_opponen_team;
        this.currentTeamValue = currentTeamValue;
        this.opponentTeamValue = opponentTeamValue;

    }

    public String getPlayer_one_your_team() {
        return player_one_your_team;
    }

    public void setPlayer_one_your_team(String player_one_your_team) {
        this.player_one_your_team = player_one_your_team;
    }

    public String getPlayer_two_your_team() {
        return player_two_your_team;
    }

    public void setPlayer_two_your_team(String player_two_your_team) {
        this.player_two_your_team = player_two_your_team;
    }

    public String getPlayer_one_opponent_team() {
        return player_one_opponent_team;
    }

    public void setPlayer_one_opponent_team(String player_one_opponent_team) {
        this.player_one_opponent_team = player_one_opponent_team;
    }

    public String getPlayer_two_opponen_team() {
        return player_two_opponen_team;
    }

    public void setPlayer_two_opponen_team(String player_two_opponen_team) {
        this.player_two_opponen_team = player_two_opponen_team;
    }

    public Integer getCurrentTeamValue() {
        return currentTeamValue;
    }

    public void setCurrentTeamValue(Integer currentTeamValue) {
        this.currentTeamValue = currentTeamValue;
    }

    public Integer getOpponentTeamValue() {
        return opponentTeamValue;
    }

    public void setOpponentTeamValue(Integer opponentTeamValue) {
        this.opponentTeamValue = opponentTeamValue;
    }
}
