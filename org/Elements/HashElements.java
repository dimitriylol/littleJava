package org.Elements;

import java.util.*;

/**
 * Created by dmytro on 21.03.16.
 */
public class HashElements {
    ArrayList<Integer> elements;

    public HashElements() {
        elements = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            elements.add(i);
    }

    public ListIterator<Integer> getIterator() {
        return elements.listIterator();
    }

    public boolean isContains(int num) {
        return elements.contains(num);
    }

    public void sortElements() {
        Collections.sort(elements);
    }
}
