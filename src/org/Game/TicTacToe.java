package org.Game;

import org.Config;

/**
 * Created by dmytro on 27.02.16.
 */
public class TicTacToe {
    public GameField field = new GameField();
    public char winner;


    public boolean nextMove(Integer[] indexesField, char sym) {
        field.setCell(indexesField[0], indexesField[1], sym);
        winner = field.isThereWinnerLine();
        return ! Config.isCorrectChar(winner) && field.isThereFreeCell();
    }
}
