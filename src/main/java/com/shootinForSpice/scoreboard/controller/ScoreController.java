package com.shootinForSpice.scoreboard.controller;

import com.shootinForSpice.scoreboard.dto.BonusRequest;
import com.shootinForSpice.scoreboard.dto.RoundRequest;
import com.shootinForSpice.scoreboard.dto.ScoreResponse;
import com.shootinForSpice.scoreboard.service.iScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shootinForSpice.scoreboard.entity.Game;
import com.shootinForSpice.scoreboard.entity.Competition;


import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ScoreController {

    @Autowired
    private iScoreService scoreService;

    @GetMapping("/test")
    public String test() {
        return "Controller is alive!";
    }

    @GetMapping("/history")
    public List<Game> getHistory() {
        // Return all games for the frontend to display
        return scoreService.getCompetition().getGames();
    }
    @GetMapping("/getscore")
    public ScoreResponse getScore(){
        return scoreService.getScore();
    }

    @PostMapping("/submitround")
    public ScoreResponse submitRound(@RequestBody RoundRequest roundRequest){
    return scoreService.submitRound(roundRequest);
    }

    @PostMapping("/finishgame")
    public ScoreResponse finishGame(@RequestBody BonusRequest bonusRequest){
        return scoreService.finishGame(bonusRequest);
    }

    @PutMapping("clearscore")
    public void clearScore(){
        scoreService.clearScore();
    }

   // @PostMapping("/newGame")
   // public startNewGame
}
