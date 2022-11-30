package com.tictactoe;

import static com.tictactoe.Utils.N;
import static com.tictactoe.Utils.getUserInput;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, int symbol) {
        super(name, symbol);
    }

    @Override
    int findMove(Board board) {
        String move_str;
        int move_int = 0;
        boolean valid_input = false;
        while (!valid_input) {
            System.out.print("Where to ? ");
            move_str = getUserInput();
            if(Character.isDigit(move_str.toCharArray()[0])) {
                move_int = Integer.parseInt(move_str);
                if ((move_int <= (N) * (N))
                        && move_int >= 1) {
                    break;
                }
            }

            if (!valid_input) {
                System.out.println("Invalid input");
                continue;
            }
        }
        return move_int;
    }
}
