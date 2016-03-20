package org;

/**
 * Created by dmytro on 20.03.16.
 */
public interface GameFieldAPI {
    FieldElement[][] getField();
    void setField(FieldElement[][] field);
    FieldElement getCell(int i, int j);
    void setCell(int i, int j, FieldElement element) throws FieldElementException;
}
