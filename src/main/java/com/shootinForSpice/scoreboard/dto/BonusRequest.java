package com.shootinForSpice.scoreboard.dto;

public class BonusRequest {
    private String playerKey;
    private boolean anubisWin; // M+1, R+2
    private boolean officeWin; // M+2, R +2
    private boolean clickbait; // R+5
    private boolean invisible; // M +5
    private boolean sub1k; // opponent +5
    private boolean threeKplus; // +5
    private boolean util100; //+5


    public boolean isOfficeWin() {
        return officeWin;
    }
    public void setOfficeWin(boolean officeWin) {
        this.officeWin = officeWin;
    }


    public String getPlayerKey() {
        return playerKey;
    }

    public void setPlayerKey(String playerKey) {
        this.playerKey = playerKey;
    }

    public boolean isAnubisWin() {
        return anubisWin;
    }

    public void setAnubisWin(boolean anubisWin) {
        this.anubisWin = anubisWin;
    }

    public boolean isClickbait() {
        return clickbait;
    }

    public void setClickbait(boolean clickbait) {
        this.clickbait = clickbait;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    public boolean isSub1k() {
        return sub1k;
    }

    public void setSub1k(boolean sub1k) {
        this.sub1k = sub1k;
    }

    public boolean isThreeKplus() {
        return threeKplus;
    }

    public void setThreeKplus(boolean threeKplus) {
        this.threeKplus = threeKplus;
    }

    public boolean isUtil100() {
        return util100;
    }

    public void setUtil100(boolean util100) {
        this.util100 = util100;
    }



}
