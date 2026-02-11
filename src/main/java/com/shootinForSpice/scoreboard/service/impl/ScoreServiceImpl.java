package com.shootinForSpice.scoreboard.service.impl;

import com.shootinForSpice.scoreboard.dto.ScoreResponse;
import com.shootinForSpice.scoreboard.entity.Competition;
import com.shootinForSpice.scoreboard.entity.Game;
import com.shootinForSpice.scoreboard.entity.Player;
import com.shootinForSpice.scoreboard.service.iScoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ScoreResponse getScore() {





        return new ScoreResponse(1,5,9, 13);
    }
}
