package org.Game;

import org.Config;

/**
 * Created by dmytro on 28.02.16.
 */
public class GameField {
    private char[][] field = new char[Config.fieldSize][Config.fieldSize];

    public GameField () { }

    public GameField (GameField anotherField) {
        for(int i = 0; i < anotherField.field.length; ++i) {
            System.arraycopy(anotherField.field[i], 0, this.field[i], 0, anotherField.field.length);
        }
    }

    @Override
    public String toString() {
        String res = "";
        for(char[] row : field) {
            for (char cell : row)
                res += (cell == '\0') ? "-" : cell;
            res += "\n";
        }
        return res;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for(char [] row : field)
            for (char cell : row)
                result = prime * result + cell;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        GameField anotherField = (GameField) obj;
        return org.Util.Predicate.checkEqualArr(anotherField.field, field);
    }

    public void setCell(int row, int col, char sym) {
        field[row][col] = sym;
    }

    public char getCell(int row, int col) {
        return field[row][col];
    }

    public boolean isThereFreeCell() {
        for (char[] row : field)
            for (char cell : row)
                if (cell == '\0')
                    return true;
        return false;

    }

    public boolean isFreeCell(Integer[] indexesField) {
        return indexesField[0] < field.length &&
                indexesField[1] < field.length &&
                getCell(indexesField[0], indexesField[1]) == '\0';
    }

    private boolean checkRow(int row) {
        char firstChar = field[row][0];
        for (int i = 0; i < field.length; ++i) {
            if (firstChar != field[row][i])
                return false;
        }
        return true;
    }

    private boolean checkColumn(int column) {
        char firstChar = field[0][column];
        for (char[] aField : field)
            if (firstChar != aField[column])
                return false;
        return true;
    }

    public char isThereWinnerLine() {
        for (int i = 0; i < field.length; ++i) {
            if (checkRow(i) && Config.isCorrectChar(field[i][0])) return field[i][0];
            if (checkColumn(i) && Config.isCorrectChar(field[0][i])) return field[0][i];
        }
        return checkDiagonals();
    }

    private char checkDiagonals() {
        char firstCharLeft = field[0][0];
        char firstCharRight = field[0][field.length - 1];
        for (int i = 0; i < field.length; ++i) {
            if (firstCharLeft != field[i][i])
                return '\0';
            if (firstCharRight != field[i][field.length - 1 - i])
                return '\0';
        }
        if (Config.isCorrectChar(firstCharLeft))
            return firstCharLeft;
        if (Config.isCorrectChar(firstCharRight))
            return firstCharRight;
        return '\0';
    }
}