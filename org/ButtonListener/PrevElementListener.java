package org.ButtonListener;

import org.CurVal;
import org.Elements.HashElements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by dmytro on 21.03.16.
 */
public class PrevElementListener extends ButtonListener implements ActionListener {

    public PrevElementListener(HashElements elements, JTextField index, JTextField value, ListIterator<Integer> iter) {
        super(elements, index, value, iter);
    }

    public void actionPerformed(ActionEvent e) {
        if (iter.hasPrevious()) {
            indexField.setText(String.valueOf(iter.previousIndex()));
            valueField.setText(String.valueOf(iter.previous()));
        }
    }
}
