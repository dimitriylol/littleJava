package org.ButtonListener;

import org.Elements.HashElements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by dmytro on 20.03.16.
 */
public class ShowButtonListener extends  ButtonListener implements ActionListener {

    public ShowButtonListener(HashElements elements, JTextField index, JTextField value, ListIterator<Integer> iter) {
        super(elements, index, value, iter);
    }

    public void actionPerformed(ActionEvent e) {
        indexField.setText("0");
        int first = 0;
        while(iter.previousIndex() != -1)
            first = iter.previous();
        valueField.setText(String.valueOf(first));
    }
}
