package org.view;

import org.media.Candy;
import org.media.CandyBox;

/**
 * Created by dmytro on 26.03.16.
 */
public class CandyView {
    public CandyView() {
    }

    private void display(Object o) {
        System.out.println(o);
    }

    public void whatInBox(CandyBox box) {
        display(box);
    }

    public void whatCandy(Candy candy) {
        display(candy);
    }
}
