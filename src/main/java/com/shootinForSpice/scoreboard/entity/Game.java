package com.shootinForSpice.scoreboard.entity;


public class Game {
    private int gameNumber;
    private int roundNumber;
    private boolean bonusesApplied;
    private boolean rSubmitted = false;
    private boolean mSubmitted = false;

    public void incrementRound() {
        this.roundNumber++;
    }

    public boolean isrSubmitted() {
        return rSubmitted;
    }

    public void setrSubmitted(boolean rSubmitted) {
        this.rSubmitted = rSubmitted;
    }

    public boolean ismSubmitted() {
        return mSubmitted;
    }

    public void setmSubmitted(boolean mSubmitted) {
        this.mSubmitted = mSubmitted;
    }

    public int getGameNumber() {
        return gameNumber;
    }


    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public boolean isBonusesApplied() {
        return bonusesApplied;
    }

    public void setBonusesApplied(boolean bonusesApplied) {
        this.bonusesApplied = bonusesApplied;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
