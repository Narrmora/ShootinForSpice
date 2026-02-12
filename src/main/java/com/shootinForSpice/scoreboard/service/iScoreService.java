package com.shootinForSpice.scoreboard.service;

import com.shootinForSpice.scoreboard.dto.RoundRequest;
import com.shootinForSpice.scoreboard.dto.ScoreResponse;

public interface iScoreService {
    ScoreResponse getScore();
    public void clearRoundCounter();
    ScoreResponse submitRound(RoundRequest roundRequest);
}
