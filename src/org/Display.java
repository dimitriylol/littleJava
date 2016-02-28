package org;

import org.Game.GameField;

/**
 * Created by dmytro on 27.02.16.
 */
public class Display {
    public static void readingError() {
        System.out.println("Sadly, but input is messed up");
    }

    public static void doWhatTheySay() {
        System.out.println("Do what they say");
    }

    public static void initChoose() {
        System.out.println("What does you choose? Enter 'X' or 'O'");
    }

    public static void enterMove() {
        System.out.println("Enter row number and column number. Example: '1 1'");
    }

    public static void whatEnd(char winner) {
        if (Config.isCorrectChar(winner))
            System.out.println("We have a winner! It's " + winner);
        else
            System.out.println("It's standoff");
    }

    public static void showField(GameField field) {
        System.out.println("Field look's like this\n" + field);
    }
}
