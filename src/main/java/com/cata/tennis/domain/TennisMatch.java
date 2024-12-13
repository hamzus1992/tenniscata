package com.cata.tennis.domain;

public class TennisMatch {
    private int playerAScore = 0;
    private int playerBScore = 0;
    private final String[] scoreNames = {"0", "15", "30", "40"};

    public String getScore() {
        if (playerAScore >= 4 && playerAScore - playerBScore >= 2) {
            return "Player A wins the game";
        }
        if (playerBScore >= 4 && playerBScore - playerAScore >= 2) {
            return "Player B wins the game";
        }
        return "Player A : " + scoreNames[playerAScore] + " / Player B : " + scoreNames[playerBScore];
    }

    public void playerAScores() {
        if (playerAScore < 4) playerAScore++;
    }

    public void playerBScores() {
        if (playerBScore < 4) playerBScore++;
    }
}
