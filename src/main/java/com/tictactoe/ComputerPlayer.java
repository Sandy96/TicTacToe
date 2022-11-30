package com.tictactoe;

public class ComputerPlayer extends Player {

    private MoveStrategy moveStrategy;

    public ComputerPlayer(String name, int symbol) {
        super(name, symbol);
        this.moveStrategy = new SimpleMoveStrategy();
    }

    @Override
    int findMove(Board board) {
        return moveStrategy.getMove(board);
    }
}
