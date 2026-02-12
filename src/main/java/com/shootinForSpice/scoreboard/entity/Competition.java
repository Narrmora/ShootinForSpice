package com.shootinForSpice.scoreboard.entity;

import java.util.List;
import java.util.Map;

public class Competition {
    private List<Game>games;
    private Map<String, Player> players;

    public Map<String, Player> getPlayers() {
        return players;
    }
    public List<Game> getGames() {
        return games;
    }

    public void setPlayers(Map<String, Player> players) {
        this.players = players;
    }
    public void setGames(List<Game> games) {
        this.games = games;
    }
}
