package org.ButtonListener;

import org.Elements.HashElements;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by dmytro on 21.03.16.
 */
public class ButtonListener {
    HashElements elements;
    JTextField indexField;
    JTextField valueField;
    ListIterator<Integer> iter;

    public ButtonListener(HashElements elements, JTextField index, JTextField value, ListIterator<Integer> iter) {
        this.elements = elements;
        indexField = index;
        valueField = value;
        this.iter = iter;
    }
}
