package org.media;

/**
 * Created by dmytro on 25.03.16.
 */
public abstract class Candy implements Comparable {
    private final int sugarPercent;
    private final String name;
    private final int weight;

    Candy(String name, int sugarPercent, int weight) {
        this.name = name;
        this.sugarPercent = sugarPercent;
        this.weight = weight;
    }

    public int getSugarPercent() {
        return sugarPercent;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Candy name: " + name + " with sugar percent " + sugarPercent + " and weight " + weight;
    }

    @Override
    public int compareTo(Object o) {
        return this.weight - ((Candy) o).getWeight();
    }
}
