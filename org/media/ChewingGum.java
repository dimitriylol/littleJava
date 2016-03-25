package org.media;

/**
 * Created by dmytro on 25.03.16.
 */
public class ChewingGum extends Candy {
    private final String color;

    public ChewingGum(CandyInit candyInit) {
        super(candyInit.name, candyInit.sugarPercent, candyInit.weight);
        this.color = candyInit.additional;
    }

    public ChewingGum(String name, int sugarPercent, int weight, String color) {
        super(name, sugarPercent, weight);
        this.color = color;
    }
}
