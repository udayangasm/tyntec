package com.tyntec.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class AppServiceTest {

    @InjectMocks
    AppService appService;

    @Spy
    GameRuleImplementation gameRuleImplementation;

    @Test
    public void Test_play(){
        //Arrange
        ReflectionTestUtils.setField(appService,"SELECTED_PLAYER_OPTION","Paper");
        ReflectionTestUtils.setField(appService,"NO_OF_ROUNDS",100);
        //Act
        List<Player> play = appService.play();
        //Assert
        assertEquals(2,play.size());
        assertEquals("Player A",play.get(0).getName());
        assertTrue(100 >= play.get(0).getWinningCount());
        assertEquals("Player B",play.get(1).getName());
        assertTrue(100 >= play.get(1).getWinningCount());
    }
}