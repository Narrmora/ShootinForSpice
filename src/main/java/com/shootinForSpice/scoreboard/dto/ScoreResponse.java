package com.shootinForSpice.scoreboard.dto;

public class ScoreResponse {
    private int currentGameNumber;
    private int currentRoundNumber;
    private int rScore;
    private int mScore;

    public ScoreResponse(int currentGameNumber, int currentRoundNumber, int rScore, int mScore) {
        this.currentGameNumber = currentGameNumber;
        this.currentRoundNumber = currentRoundNumber;
        this.rScore = rScore;
        this.mScore = mScore;
    }

    public int getCurrentGameNumber() {
        return currentGameNumber;
    }
    public int getCurrentRoundNumber(){
        return currentRoundNumber;
    }
    public int getRScore(){
        return rScore;
    }
    public int getMScore(){
        return mScore;
    }

    public void setCurrentGameNumber(int currentGameNumber){
        this.currentGameNumber = currentGameNumber;
    }
    public void setCurrentRoundNumber(int currentRoundNumber){
        this.currentRoundNumber = currentRoundNumber;
    }
    public void setRScore(int rScore){
        this.rScore = rScore;
    }
    public void setMScore(int mScore){
        this.mScore = mScore;
    }

}
