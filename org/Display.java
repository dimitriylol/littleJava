package org;

import org.ButtonListener.ChangeElementListener;
import org.ButtonListener.NextElementListener;
import org.ButtonListener.PrevElementListener;
import org.ButtonListener.ShowButtonListener;
import org.Elements.HashElements;
import org.error.BorderLayoutException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ListIterator;

/**
 * Created by dmytro on 20.03.16.
 */

public class Display extends JFrame {
    Container container;
    JTextField displayIndex;
    JTextField displayValue;
    JTextField displayElementsNumber;
    ListIterator<Integer> iter;

    public Display(String name) {
        super(name);
        this.setBounds(100,100,250,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = this.getContentPane();
    }

    boolean isBorderLayout(Container pane) {
        return (pane.getLayout() instanceof BorderLayout);
    }

    public void showList(HashElements elements) throws BorderLayoutException {
        iter = elements.getIterator();
        if (!isBorderLayout(container))
            throw new BorderLayoutException("pane isn't BorderLayout!");

        container.add(getCenter(), BorderLayout.CENTER);
        container.add(getEast(elements), BorderLayout.EAST);
        container.add(getSouth(elements), BorderLayout.SOUTH);
    }

    JButton addButtonWithListener (String buttonLabel, ActionListener listener) {
        JButton button = new JButton(buttonLabel);
        button.addActionListener(listener);
        return button;
    }

    JButton addDisplayButton(HashElements elements) {
        return addButtonWithListener("Show", new ShowButtonListener(elements, displayIndex, displayValue, iter));
    }

    JButton addPrevElementButton(HashElements elements) {
        return addButtonWithListener("<-", new PrevElementListener(elements, displayIndex, displayValue, iter));
    }

    JButton addNextElementButton(HashElements elements) {
        return addButtonWithListener("->", new NextElementListener(elements, displayIndex, displayValue, iter));
    }

    JButton addChangeButton(JTextField fieldVal, HashElements elements) {
        return addButtonWithListener("Change", new ChangeElementListener(elements, displayValue, fieldVal, iter));
    }

    private JPanel getEast(HashElements elements) {
        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.add(addDisplayButton(elements), BorderLayout.NORTH);
        eastPanel.add(addNextElementButton(elements), BorderLayout.EAST);
        eastPanel.add(addPrevElementButton(elements), BorderLayout.WEST);
        displayElementsNumber = new JTextField("elements number");
        eastPanel.add(displayElementsNumber, BorderLayout.SOUTH);
        return eastPanel;
    }

    private JPanel getSouth(HashElements elements) {
        JPanel southPanel = new JPanel(new BorderLayout());
        JTextField newValue = new JTextField("", 5);
        southPanel.add(newValue, BorderLayout.NORTH);
        southPanel.add(addChangeButton(newValue, elements), BorderLayout.SOUTH);
        return southPanel;
    }

    private JPanel getCenter() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        displayIndex = new JTextField("", 5);
        displayValue = new JTextField("", 5);
        setCentralPart(centerPanel, "Index", displayIndex, BorderLayout.WEST);
        setCentralPart(centerPanel, "Value", displayValue, BorderLayout.EAST);
        return centerPanel;
    }

    private void setCentralPart(JPanel centerPanel, String labelName, JTextField tField, String layoutPosition) {
        JPanel valuePanel = new JPanel(new BorderLayout());
        valuePanel.add(new JLabel(labelName, JLabel.CENTER), BorderLayout.NORTH);
        valuePanel.add(tField, BorderLayout.SOUTH);
        centerPanel.add(valuePanel, layoutPosition);
    }



}
