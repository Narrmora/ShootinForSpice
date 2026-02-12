package com.shootinForSpice.scoreboard.service.impl;

import com.shootinForSpice.scoreboard.dto.RoundRequest;
import com.shootinForSpice.scoreboard.dto.ScoreResponse;
import com.shootinForSpice.scoreboard.entity.Competition;
import com.shootinForSpice.scoreboard.entity.Game;
import com.shootinForSpice.scoreboard.entity.Player;
import com.shootinForSpice.scoreboard.service.iScoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImpl implements iScoreService {

    private Competition competition;

    public ScoreServiceImpl() {
        // Initialize the competition and its players
        this.competition = new Competition();
        competition.setPlayers(Map.of(
                "M", new Player("Miška"),
                "R", new Player("Romi")
        ));
        competition.setGames(new ArrayList<>());

        Game firstGame = new Game();
        firstGame.setGameNumber(1);
        firstGame.setRoundNumber(1);
        firstGame.setBonusesApplied(false);

        competition.getGames().add(firstGame);
    }
    public ScoreResponse submitRound(RoundRequest roundRequest) {
        List<Game> games = competition.getGames();
        Game currentGame = games.get(games.size() - 1);
        Player currentPlayer = competition.getPlayers().get(roundRequest.getPlayerKey());
        int points = 0;

        if (roundRequest.isTwoPlusKills()) {
            points = points + 1;
        }
        if (roundRequest.isGrenadeKill()) {
            points = points + 3;
        }
        if (roundRequest.isZeusKill()) {
            points = points + 3;
        }
        if (roundRequest.isKnifeKill()) {
            points = points + 4;
        }
        if (roundRequest.isSmokeDefuse()) {
            points = points + 3;
        }

        currentPlayer.setTotalScore(currentPlayer.getTotalScore() + points);

        if (roundRequest.getPlayerKey().equals("R")){
            currentGame.setrSubmitted(true);
        }
        else currentGame.setmSubmitted(true);

        if (currentGame.isrSubmitted() && currentGame.ismSubmitted()) {
            currentGame.incrementRound();
            currentGame.setmSubmitted(false);
            currentGame.setrSubmitted(false);
        }
        int rScore = competition.getPlayers().get("R").getTotalScore();
        int mScore = competition.getPlayers().get("M").getTotalScore();
        int currentRound = currentGame.getRoundNumber();
        ScoreResponse scoreResponse = new ScoreResponse (currentGame.getGameNumber(), currentRound,
                rScore, mScore);

        return scoreResponse;
    }


    @Override
    public void clearRoundCounter() {
        List<Game> games = competition.getGames();
        if (games.isEmpty()) {
            throw new IllegalStateException("No active game to reset round counter.");
        }
        Game currentGame = games.get(games.size() - 1);
        currentGame.setRoundNumber(1);
    }



    @Override
    public ScoreResponse getScore() {

        return new ScoreResponse(1,5,9, 13);
    }
}
