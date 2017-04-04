package com.robmcbryde;

/**
 * Created by robertmcbryde on 26/02/2017.
 */
public class FootballTeam implements Comparable<FootballTeam> {

    private int gamesWon;

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon){
        if (gamesWon < 0) {
            throw new IllegalArgumentException("Number of games won for a Football team cannot be a negative number");
        }
        this.gamesWon = gamesWon;
    }

    public int compareTo(FootballTeam otherTeam) {
        return this.gamesWon - otherTeam.gamesWon;
    }
}