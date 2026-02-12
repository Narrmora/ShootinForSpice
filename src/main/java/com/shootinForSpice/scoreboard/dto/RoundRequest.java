package com.shootinForSpice.scoreboard.dto;

public class RoundRequest {
    String playerKey;
    boolean twoPlusKills;
    boolean grenadeKill;
    boolean zeusKill;
    boolean knifeKill;
    boolean smokeDefuse;


    public String getPlayerKey() {
        return playerKey;
    }

    public void setPlayerKey(String playerKey) {
        this.playerKey = playerKey;
    }

    public boolean isTwoPlusKills() {
        return twoPlusKills;
    }

    public void setTwoPlusKills(boolean twoPlusKills) {
        this.twoPlusKills = twoPlusKills;
    }

    public boolean isGrenadeKill() {
        return grenadeKill;
    }

    public void setGrenadeKill(boolean grenadeKill) {
        this.grenadeKill = grenadeKill;
    }

    public boolean isZeusKill() {
        return zeusKill;
    }

    public void setZeusKill(boolean zeusKill) {
        this.zeusKill = zeusKill;
    }

    public boolean isKnifeKill() {
        return knifeKill;
    }

    public void setKnifeKill(boolean knifeKill) {
        this.knifeKill = knifeKill;
    }

    public boolean isSmokeDefuse() {
        return smokeDefuse;
    }

    public void setSmokeDefuse(boolean smokeDefuse) {
        this.smokeDefuse = smokeDefuse;
    }
}
