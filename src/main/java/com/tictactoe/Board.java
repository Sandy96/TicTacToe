package com.tictactoe;

import static com.tictactoe.Utils.N;
import static com.tictactoe.Utils.HSPACE;

public class Board {
    protected int[][] board;

    public Board() {
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }
    }

    public int getValueFromBoard(int i, int j) {
        return board[i][j];
    }

    public void setValueInBoard(int i, int j, int val) {
        board[i][j] = val;
    }

    protected WinConfig isWinningConfig() {
        WinConfig w = WinConfig.WIN;
        // rows
        for (int i = 0; i < N; i++) {
            if ((board[i][0] != 0) && (board[i][0] == board[i][1])
                    && (board[i][0] == board[i][2])) {
                return w;
            }
        }
        // columns
        for (int i = 0; i < N; i++) {
            if ((board[0][i] != 0) && (board[0][i] == board[1][i])
                    && (board[0][i] == board[2][i])) {
                return w;
            }
        }
        // diags
        if ((board[0][0] != 0) && (board[0][0] == board[1][1])
                && (board[0][0] == board[2][2])) {
            return w;
        }

        if ((board[2][0] != 0) && (board[2][0] == board[1][1])
                && (board[2][0] == board[0][2])) {
            return w;
        }

        // draw
        w = WinConfig.DRAW;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0)
                    w = WinConfig.NONE;
            }
        return w;

    }

    private String getRowString(int row) {
        String s = "";
        for (int i = 0; i < N; i++) {
            switch (board[row][i]) {
                case 0:
                    s += " ";
                    break;
                case 1:
                    s += "O";
                    break;
                case 2:
                    s += "X";
            }

            if (i != N - 1) {
                s += " | ";
            }
        }

        s += String.format("%" + HSPACE + "s", "");

        for (int i = 0; i < N; i++) {
            s += row * 3 + i + 1;

            if (i == N - 1) {
                s += "\n";
            } else {
                s += " | ";
            }
        }
        return s;
    }

    public String toString() {
        String s = "";
        // iterate through the rows
        for (int i = 0; i < N; i++) {
            s += getRowString(i);
        }
        return s;
    }
}
