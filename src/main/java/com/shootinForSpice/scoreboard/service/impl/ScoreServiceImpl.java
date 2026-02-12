package com.shootinForSpice.scoreboard.service.impl;

import com.shootinForSpice.scoreboard.dto.BonusRequest;
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
    @Override
    public ScoreResponse finishGame(BonusRequest bonusRequest) {
        List<Game> games = competition.getGames();
        Game currentGame = getCurrentGame();
        // Player currentPlayer = competition.getPlayers().get(bonusRequest.getPlayerKey());
        String currentPlayerKey = bonusRequest.getPlayerKey();
        int mBonusPoints = 0;
        int rBonusPoints = 0;

        if (currentPlayerKey.equals("M")) {
            if (bonusRequest.isAnubisWin()) {
                mBonusPoints = mBonusPoints + 1;
            }
            if (bonusRequest.isOfficeWin()) {
                mBonusPoints = mBonusPoints + 2;
            }
            if (bonusRequest.isClickbait()) {
                rBonusPoints = rBonusPoints + 5;
            }
            if (bonusRequest.isSub1k()) {
                rBonusPoints = rBonusPoints + 5;
            }
            if (bonusRequest.isThreeKplus()) {
                mBonusPoints = mBonusPoints + 5;
            }
            if (bonusRequest.isUtil100()) {
                mBonusPoints = mBonusPoints + 5;
            }
        }
        if (currentPlayerKey.equals("R")) {
            if (bonusRequest.isAnubisWin()) {
                rBonusPoints = rBonusPoints + 2;
            }
            if (bonusRequest.isOfficeWin()) {
                rBonusPoints = rBonusPoints + 2;
            }
            if (bonusRequest.isInvisible()) {
                mBonusPoints = mBonusPoints + 5;
            }
            if (bonusRequest.isSub1k()) {
                mBonusPoints = mBonusPoints + 5;
            }
            if (bonusRequest.isThreeKplus()) {
                rBonusPoints = rBonusPoints + 5;
            }
            if (bonusRequest.isUtil100()) {
                rBonusPoints = rBonusPoints + 5;
            }
        }

        Player mPlayer = competition.getPlayers().get("M");
        Player rPlayer = competition.getPlayers().get("R");

        mPlayer.setTotalScore(mPlayer.getTotalScore() + mBonusPoints);
        rPlayer.setTotalScore(rPlayer.getTotalScore() + rBonusPoints);

        currentGame.setBonusesApplied(true);
        if (bonusRequest.getPlayerKey().equals("R")){
            currentGame.setrSubmitted(true);
        }
        else currentGame.setmSubmitted(true);

        int currentRound = currentGame.getRoundNumber();
        ScoreResponse scoreResponse = new ScoreResponse (currentGame.getGameNumber(), currentRound,
                competition.getPlayers().get("R").getTotalScore(),competition.getPlayers().get("M").getTotalScore());

        if (currentGame.isrSubmitted() && currentGame.ismSubmitted()) {
            Game nextGame = new Game();
            nextGame.setGameNumber(currentGame.getGameNumber() + 1);
            nextGame.setRoundNumber(1);
            nextGame.setBonusesApplied(false);
            games.add(nextGame);
            currentGame.setmSubmitted(false);
            currentGame.setrSubmitted(false);
        }
        return scoreResponse;

    }

        @Override
        public ScoreResponse getScore () {
            List<Game> games = competition.getGames();
            Game currentGame = getCurrentGame();
            return new ScoreResponse(currentGame.getGameNumber(), currentGame.getRoundNumber(), competition.getPlayers().get("R").getTotalScore(), competition.getPlayers().get("M").getTotalScore());
        }

    @Override
    public ScoreResponse submitRound(RoundRequest roundRequest) {
        List<Game> games = competition.getGames();
        Game currentGame = getCurrentGame();
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

        int rScore = competition.getPlayers().get("R").getTotalScore();
        int mScore = competition.getPlayers().get("M").getTotalScore();
        int currentRound = currentGame.getRoundNumber();
        ScoreResponse scoreResponse = new ScoreResponse (currentGame.getGameNumber(), currentRound,
                rScore, mScore);
        if (currentGame.isrSubmitted() && currentGame.ismSubmitted()) {
            currentGame.incrementRound();
            currentGame.setmSubmitted(false);
            currentGame.setrSubmitted(false);
        }
        return scoreResponse;
    }
    @Override
    public void clearScore() {
        List<Game> games = competition.getGames();
        if (games.isEmpty()) {
            throw new IllegalStateException("No active game to reset.");
        }
        Game currentGame = games.get(games.size() - 1);
        currentGame.setRoundNumber(1);
        currentGame.setGameNumber(1);
        competition.getPlayers().get("M").setTotalScore(0);
        competition.getPlayers().get("R").setTotalScore(0);
    }
    @Override
    public Game getCurrentGame(){
        List<Game> games = competition.getGames();
        if (games.isEmpty()) throw new IllegalStateException("No active game.");
        return games.get(games.size() - 1);
    }
}
