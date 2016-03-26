package org;

import org.controller.InputControl;
import org.media.CandyBox;
import org.view.CandyView;

public class Main {

    public static void main(String[] args) {
        InputControl controller = new InputControl();
        CandyView view = new CandyView();
        CandyBox candyBox = controller.createCandyBox(new String[]{"TastyCandy"}, new String[]{"m&m"});
        view.whatInBox(candyBox);
    }
}
