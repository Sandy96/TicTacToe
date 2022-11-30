package com.tictactoe;

public abstract class Player {

    private String name;

    private int symbol;

    public Player(String name, int symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    abstract int findMove(Board board);

    public String getName() {
        return name;
    }

    int getPlayerType() {
        return symbol;
    }
}
