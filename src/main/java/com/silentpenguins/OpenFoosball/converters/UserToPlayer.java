package com.silentpenguins.OpenFoosball.converters;

import com.silentpenguins.OpenFoosball.model.User;
import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Vector;

@Component
public class UserToPlayer implements Converter<User, Player> {

    @Override
    public Player convert(User source) {
        Player player = new Player();

        player.setId(source.getId());
        player.setUserName(source.getUserName());
        player.setFirstName(source.getFirstName());
        player.setLastName(source.getLastName());
        player.setProfileImage(source.getProfileImage());
        player.setMatches(source.getMatches());
        player.setWins(source.getWins());
        player.setPoints(source.getPoints());

        return player;
    }

    public Vector<Player> convertVector(Vector<User> source){
        Vector<Player> players= new Vector<>();

        for (User s: source) {
            players.add(convert(s));
        }

        return players;
    }
}
