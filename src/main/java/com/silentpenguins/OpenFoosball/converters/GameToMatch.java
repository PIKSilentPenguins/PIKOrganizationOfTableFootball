package com.silentpenguins.OpenFoosball.converters;

import com.silentpenguins.OpenFoosball.model.Game;
import com.silentpenguins.OpenFoosball.pojo.Match;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Vector;

@Component
public class GameToMatch implements Converter<Game, Match> {

    @Override
    public Match convert(Game source) {
        Match match = new Match();

        match.setId(source.getId());
        match.setRightScore(source.getRightScore());
        match.setLeftScore(source.getLeftScore());
        match.setType(source.getScoring().getName());
        match.setLeftTeam(new Vector<>(source.getLeftTeam()) );
        match.setRightTeam(new Vector<>(source.getRightTeam()));

        return match;
    }

    public Vector<Match> convertVector(Vector<Game> source){
        Vector<Match> matches = new Vector<>();

        for (Game g: source ) {
            matches.add(convert(g));
        }

        return matches;
    }
}
