package com.robmcbryde;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

    private FootballTeam team;
    private final static int NUMBER_OF_GAMES = 3;

    public static Object[] nbOfGamesWon() {
        return $(0, 1, 3);
    }

    public static Object[] illegalGameWins() {
        return $(-10, -1);
    }

    @Before
    public void setUp() throws Exception {
        team = new FootballTeam();
    }

    @Test
    public void testCanConstructTeam() throws Exception {
        assertEquals(0, team.getGamesWon());
    }

    @Test
    @Parameters(method = "nbOfGamesWon")
    public void testCanSetGamesWonOnTeam(int numberOfGamesWon) throws Exception {
        team.setGamesWon(numberOfGamesWon);
        assertEquals(numberOfGamesWon + " games won set on team should be reflected on get games won", numberOfGamesWon, team.getGamesWon());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegalGameWins")
    public void testThrowIllegalArgumentException_OnCanSetGamesWon_whenNegativeValueProvided(int numberOfGamesWon) throws Exception {
        team.setGamesWon(numberOfGamesWon);
    }

    @Test
    public void testFootballTeamsAreComparable() throws Exception {
        assertTrue("FootballTeam should implement Comparable", team != null);
    }

    @Test
    public void testWithMoreGamesWins_ComesAboveLesserWinTeam() throws Exception {
        team.setGamesWon(3);
        FootballTeam team2 = new FootballTeam();
        team2.setGamesWon(2);

        assertTrue("Team with 3 wins should be greater than team with 2 wins", team.compareTo(team2) > 0);
    }

    @Test
    public void testWithLessGamesWins_ComesBelowGreaterWinTeam() throws Exception {
        team.setGamesWon(2);
        FootballTeam team2 = new FootballTeam();
        team2.setGamesWon(3);

        assertTrue("Team with 2 wins should be greater than team with 3 wins", team.compareTo(team2) < 0);
    }

    @Test
    public void testTeamsWithSameGameWins_areEquallyRanked() throws Exception {
        team.setGamesWon(0);
        FootballTeam team2 = new FootballTeam();
        team2.setGamesWon(0);

        assertTrue("Teams with same number of wins are ranked equally", team.compareTo(team2) == 0);
    }

}