package org;

import org.Elements.HashElements;
import org.error.BorderLayoutException;

/**
 * Created by dmytro on 20.03.16.
 */
public class Laba4 {
    public static void main(String[] args) {
        HashElements elements = new HashElements();
        Display display = new Display("Lab4");

        try {
            display.showList(elements);
            display.setVisible(true);
        } catch (BorderLayoutException e) {
            e.printStackTrace();
        }
    }
}
