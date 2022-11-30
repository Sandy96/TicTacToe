package com.tictactoe;

public class InvalidUserInputException extends RuntimeException {

    public InvalidUserInputException() {
        super("Invalid user input");
    }
}
