package org;

import org.controller.InputControl;
import org.media.CandyBox;
import org.view.CandyView;

public class Main {

    public static void main(String[] args) {
        InputControl controller = new InputControl();
        CandyView view = new CandyView();
        String[] tables = {"TastyCandy"};
        String[] names = {"m&m", "Orbit"};
        view.whatCandy(controller.createCandy(tables, "m&m"));
        view.whatCandy(controller.createCandy(tables, "Orbit"));
        CandyBox candyBox = controller.createCandyBox(tables, names);
        view.whatInBox(candyBox);
        candyBox.sortCandiesByWeight();
        view.whatInBox(candyBox);
        view.whatCandy(candyBox.findCandyBySugarPercent(20, 25));
    }
}
