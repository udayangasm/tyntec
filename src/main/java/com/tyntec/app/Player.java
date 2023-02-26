package com.tyntec.app;

public class Player {

    private String name;
    private GameOption selectedOption;
    private int winningCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameOption getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(GameOption selectedOption) {
        this.selectedOption = selectedOption;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public void setWinningCount(int winningCount) {
        this.winningCount = winningCount;
    }
}