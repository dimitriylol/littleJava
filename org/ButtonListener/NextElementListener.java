package org.ButtonListener;

import org.Elements.HashElements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

/**
 * Created by dmytro on 21.03.16.
 */
public class NextElementListener extends ButtonListener implements ActionListener {
    public NextElementListener(HashElements elements, JTextField index, JTextField value, ListIterator<Integer> iter) {
        super(elements, index, value, iter);
    }

    public void actionPerformed(ActionEvent e) {
        if (iter.hasNext()) {
            indexField.setText(String.valueOf(iter.nextIndex()));
            valueField.setText(String.valueOf(iter.next()));
        }
    }
}
