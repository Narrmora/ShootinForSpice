package com.shootinForSpice.scoreboard.entity;


public class Game {
    int gameNumber;
    int roundNumber;
    boolean bonusesApplied;

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
