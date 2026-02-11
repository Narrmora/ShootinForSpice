package com.shootinForSpice.scoreboard.service.impl;

import com.shootinForSpice.scoreboard.dto.ScoreResponse;
import com.shootinForSpice.scoreboard.service.iScoreService;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements iScoreService {
    @Override
    public ScoreResponse getScore() {
        return new ScoreResponse(1,5,9, 13);
    }
}
