package com.tyntec.app;

import java.util.List;
import java.util.Random;

public enum GameOption {

    Scissors,
    Rock,
    Paper;

    private static final List<GameOption> VALUES =List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static GameOption randomOption()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}