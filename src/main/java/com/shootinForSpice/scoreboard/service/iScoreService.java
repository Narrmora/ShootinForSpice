package com.shootinForSpice.scoreboard.service;

import com.shootinForSpice.scoreboard.dto.BonusRequest;
import com.shootinForSpice.scoreboard.dto.RoundRequest;
import com.shootinForSpice.scoreboard.dto.ScoreResponse;
import com.shootinForSpice.scoreboard.entity.Game;

import java.util.List;

public interface iScoreService {
    ScoreResponse getScore();
    public void clearScore();
    ScoreResponse submitRound(RoundRequest roundRequest);
    public Game getCurrentGame();
    public ScoreResponse finishGame(BonusRequest bonusRequest);
    public List<Game> getAllGames();


    }
