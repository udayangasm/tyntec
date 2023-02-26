package com.tyntec.app;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameRuleImplementation implements GameRule {

    @Override
    public GameOption winningOption( GameOption gameOption1, GameOption gameOption2){

        List<GameOption> options = new ArrayList<>();
        options.add(gameOption1);
        options.add(gameOption2);

        if (options.contains(GameOption.Scissors) && options.contains(GameOption.Paper)){
            return GameOption.Scissors;
        }else if (options.contains(GameOption.Rock) && options.contains( GameOption.Scissors)){
            return GameOption.Rock;
        }else if (options.contains( GameOption.Paper) && options.contains( GameOption.Rock)){
            return GameOption.Paper;
        }else{
            return null;
        }
    }
}