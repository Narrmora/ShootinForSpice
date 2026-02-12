package com.shootinForSpice.scoreboard.service;

import com.shootinForSpice.scoreboard.dto.RoundRequest;
import com.shootinForSpice.scoreboard.dto.ScoreResponse;

public interface iScoreService {
    ScoreResponse getScore();

    ScoreResponse submitRound(RoundRequest roundRequest);
}
