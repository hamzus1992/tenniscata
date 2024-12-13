package com.cata.tennis.domain;

import org.springframework.stereotype.Service;

@Service
public class TennisMatchService implements TennisMatchPort {

    private final TennisMatchFactory tennisMatchFactory;

    public TennisMatchService(TennisMatchFactory tennisMatchFactory) {
        this.tennisMatchFactory = tennisMatchFactory;
    }

    @Override
    public String computeScore(String input) {
        TennisMatch match = tennisMatchFactory.createTennisMatch();
        StringBuilder result = new StringBuilder();
        for (char point : input.toCharArray()) {
            if (point == 'A') {
                match.playerAScores();
            } else if (point == 'B') {
                match.playerBScores();
            }
            result.append(match.getScore()).append("\n");
        }
        return result.toString().trim();
    }
}
