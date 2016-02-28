package org;

/**
 * Created by dmytro on 27.02.16.
 */
public final class Config {
    public final static char X = 'X';
    public final static char O = 'O';
    public final static boolean isCorrectChar (char input) {
        return input == X || input == O;
    }
    public final static int fieldSize = 3;
}
