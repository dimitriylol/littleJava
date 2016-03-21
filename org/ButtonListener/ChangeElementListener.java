package org.ButtonListener;

import org.Elements.HashElements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

/**
 * Created by dmytro on 21.03.16.
 */
public class ChangeElementListener extends ButtonListener implements ActionListener {
    private final JTextField newVal;

    public ChangeElementListener(HashElements elements, JTextField value, JTextField newValue, ListIterator<Integer> iter) {
        super(elements, value, newValue, iter);
        this.newVal = newValue;
    }

    void showDialog(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Output", JOptionPane.PLAIN_MESSAGE);
    }

    public void actionPerformed(ActionEvent e) {
        int newVal;
        try {
            newVal = Integer.parseInt(this.newVal.getText());
        } catch (NumberFormatException err) {
            showDialog("wrong input " + this.newVal.getText());
            return;
        }
        if (elements.isContains(newVal))
            showDialog("val " + newVal + " has already in hashSet");
        else {
            iter.set(newVal);
            valueField.setText(this.newVal.getText());
        }
    }
}
