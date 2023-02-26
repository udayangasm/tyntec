package com.tyntec.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppService {

    @Value("${selected-player-option}")
    private String SELECTED_PLAYER_OPTION;

    @Value("${no-of-rounds}")
    private int NO_OF_ROUNDS;

    @Autowired
    GameRuleImplementation gameRuleImplementation;

    public List<Player> play(){

        List<Player> playerList = new ArrayList<>();

        Player  playerA = new Player();
        playerA.setName("Player A");
        playerA.setSelectedOption(GameOption.valueOf(SELECTED_PLAYER_OPTION));
        playerList.add(playerA);

        Player  playerB = new Player();
        playerB.setName("Player B");
        playerList.add(playerB);

        for (int i = 0 ; i < NO_OF_ROUNDS ; i++){

            playerB.setSelectedOption(GameOption.randomOption());

            GameOption winningOption = gameRuleImplementation.winningOption(playerA.getSelectedOption(),playerB.getSelectedOption());

            if (winningOption == null){
                continue;
            }else if (winningOption == playerB.getSelectedOption()){
                playerB.setWinningCount(playerB.getWinningCount() +1);
            }else if (winningOption == playerA.getSelectedOption()){
                playerA.setWinningCount(playerA.getWinningCount() +1);
            }
        }

        System.out.println(playerA.getName() + " wins "+ playerA.getWinningCount()+ " of "+NO_OF_ROUNDS+" games");
        System.out.println(playerB.getName() + " wins "+ playerB.getWinningCount()+ " of "+NO_OF_ROUNDS+" games");
        System.out.println("Tie: "+(NO_OF_ROUNDS - playerA.getWinningCount() - playerB.getWinningCount())+" of "+NO_OF_ROUNDS+" games");

        return playerList;
    }
}