package org;

import org.controller.InputControl;
import org.media.Candy;
import org.media.CandyBox;
import org.view.CandyView;

public class Main {

    public static void main(String[] args) {
        InputControl controller = new InputControl();
        CandyView view = new CandyView();
        String[] tables = {"TastyCandy"};
        String[] names = {"m&m"};
        Candy candy = controller.createCandy(tables, "m&m");
        view.whatCandy(candy);
        CandyBox candyBox = controller.createCandyBox(tables, names);
        view.whatInBox(candyBox);
    }
}
