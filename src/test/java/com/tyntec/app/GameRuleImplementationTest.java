package com.tyntec.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class GameRuleImplementationTest {

    @InjectMocks
    GameRuleImplementation gameRuleImplementation;

    @Test
    public void Test_winning_option_between_rock_and_paper(){
        //Arrange
        //Act
        GameOption winningOption = gameRuleImplementation.winningOption(GameOption.Rock,GameOption.Paper);
        //Assert
        assertEquals(GameOption.Paper, winningOption);
    }

    @Test
    public void Test_winning_option_between_rock_and_scissors(){
        //Arrange
        //Act
        GameOption winningOption = gameRuleImplementation.winningOption(GameOption.Rock,GameOption.Scissors);
        //Assert
        assertEquals(GameOption.Rock, winningOption);
    }

    @Test
    public void Test_winning_option_between_scissors_and_paper(){
        //Arrange
        //Act
        GameOption winningOption = gameRuleImplementation.winningOption(GameOption.Scissors,GameOption.Paper);
        //Assert
        assertEquals(GameOption.Scissors, winningOption);
    }
}
