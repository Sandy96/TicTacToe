package com.tictactoe;

import static com.tictactoe.Utils.N;

public class SimpleMoveStrategy implements MoveStrategy {

    @Override
    public int getMove(Board board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board.getValueFromBoard(i, j) == 0)
                    return (i * 3 + j + 1);
            }
        }
        return 0;
    }
}
