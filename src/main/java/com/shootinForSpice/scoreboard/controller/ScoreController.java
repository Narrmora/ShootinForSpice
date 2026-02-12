package com.shootinForSpice.scoreboard.controller;

import com.shootinForSpice.scoreboard.dto.BonusRequest;
import com.shootinForSpice.scoreboard.dto.RoundRequest;
import com.shootinForSpice.scoreboard.dto.ScoreResponse;
import com.shootinForSpice.scoreboard.service.iScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private iScoreService scoreService;

    @GetMapping("/test")
    public String test() {
        return "Controller is alive!";
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
