package org;

/**
 * Created by dmytro on 20.03.16.
 */
public class GameField implements GameFieldAPI {
    int rowSize, colSize;
    FieldElement[][] field;

    public GameField(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        field = new FieldElement[rowSize][colSize];
        for (int i = 0; i < rowSize; i++)
            for (int j = 0; j < colSize; j++)
                field[i][j] = new EmptyElement();
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++)
                res += field[i][j].consoleDraw();
            res += "\n";
        }
        return res;
    }

    public FieldElement[][] getField() {
        return field;
    }

    public void setField(FieldElement[][] field) {
        this.field = field;
    }

    public FieldElement getCell(int i, int j) {
        return field[i][j];
    }

    public void setCell(int i, int j, FieldElement element) throws FieldElementException {
        if (field[i][j] instanceof EmptyElement)
            field[i][j] = element;
        else
            throw new FieldElementException("set " + element.consoleDraw() + " to not empty cell [" + i + "][" + j + "]");
    }
}
