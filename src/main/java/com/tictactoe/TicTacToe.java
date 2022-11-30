package com.tictactoe;

import static com.tictactoe.Utils.*;

public class TicTacToe {
    
    Player player1;
    Player player2;
    
    Board board;
    
    GameType gameType;

    public TicTacToe(GameType gameType) {
        this.board = new Board();
        this.gameType = gameType;
    }
    
    public void initialisePlayers() {
        switch (gameType) {
            case HUMAN_VS_HUMAN:
                System.out.println("Enter 1st player's name");
                player1 = new HumanPlayer(getUserInput(), 1);
                
                System.out.println("Enter 2nd player's name");
                player2 = new HumanPlayer(getUserInput(), 2);
                break;
            case HUMAN_VS_COMPUTER:
                System.out.println("Enter player name");
                player1 = new HumanPlayer(getUserInput(), 1);

                player2 = new ComputerPlayer("Computer", 2);
        }

        System.out.println("\nPlayer 1 " + player1.getName()
                + " vs Player 2 " + player2.getName() + ":");
    }

    public boolean setMove(int move, Player player) {
        int x_coord = (move - 1) / 3;
        int y_coord = (move - 1) % 3;

        if (board.getValueFromBoard(x_coord, y_coord) == 0) {
            board.setValueInBoard(x_coord, y_coord, player.getPlayerType());
            return true;
        } else {
            System.out.println("Invalid move");
            return false;
        }
    }

    public WinConfig checkResult(Player player) {
        WinConfig w;
        if ((w = board.isWinningConfig()) == WinConfig.WIN) {
            System.out.println("");
            System.out.println(board);
            System.out.printf("%s won", player.getName());
        } else if (w == WinConfig.DRAW) {
            System.out.println("");
            System.out.println(board);
            System.out.println("Well played. It is a draw!");
        }
        return w;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public static void main(String[] args) {
        System.out.println("Select game type\n1 for Human VS Human\n2 for Human VS Computer\n");
        GameType gameType = parseGameTypeFromUserInput(getUserInput());
        
        TicTacToe ticTacToe = new TicTacToe(gameType);
        
        ticTacToe.initialisePlayers();

        int move1 = 0;
        int move2 = 0;
        WinConfig w;

        System.out.println("Please make your move selection by entering a number 1-9 corresponding to the movement key on the right.\n");
        System.out.println(ticTacToe.getBoard());

        while (ticTacToe.getBoard().isWinningConfig() == WinConfig.NONE) {
            do {
                move1 = ticTacToe.getPlayer1().findMove(ticTacToe.getBoard());
            } while (!ticTacToe.setMove(move1, ticTacToe.getPlayer1()));

            w = ticTacToe.checkResult(ticTacToe.getPlayer1());

            if(w!= WinConfig.NONE)
                break;

            do {
                move2 = ticTacToe.getPlayer2().findMove(ticTacToe.getBoard());
            } while (!ticTacToe.setMove(move2, ticTacToe.getPlayer2()));

            w = ticTacToe.checkResult(ticTacToe.getPlayer2());

            if(w!= WinConfig.NONE)
                break;

            System.out.println("");
            System.out.println("Player 1 have put an X in the "
                    + getPosDescription(move1)
                    + ". Player 2 have put a O in the "
                    + getPosDescription(move2) + ".");

            System.out.println(ticTacToe.getBoard());
        }
        
        
    }
}
