package com.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

    private static BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    protected static final int N = 3;
    protected static final int HSPACE = 20;

    protected static String getUserInput() {
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return input;
    }

    public static String getPosDescription(int pos) {
        String str = "";
        if (pos == 5) {
            str = "center";
            return str;
        }

        if ((pos - 1) / 3 == 0) {
            str += "upper ";
        } else if ((pos - 1) / 3 == 1) {
            str += "middle ";
        } else
            str += "lower ";

        if ((pos - 1) % 3 == 0)
            str += "left";
        else if ((pos - 1) % 3 == 1)
            str += "middle";
        else
            str += "right";

        return str;
    }

    public static GameType parseGameTypeFromUserInput(String input) {
        try {
            Integer userInput = Integer.parseInt(input);
            switch (userInput) {
                case 1:
                    return GameType.HUMAN_VS_HUMAN;
                case 2:
                    return GameType.HUMAN_VS_COMPUTER;
                default:
                    throw new InvalidUserInputException();
            }
        } catch (NumberFormatException ex) {
            throw new InvalidUserInputException();
        }
    }
}
