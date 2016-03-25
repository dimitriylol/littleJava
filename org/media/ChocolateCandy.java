package org.media;

/**
 * Created by dmytro on 25.03.16.
 */
public class ChocolateCandy extends Candy {
    private final String filling;
    ChocolateCandy(CandyInit candyInit) {
        super(candyInit.name, candyInit.sugarPercent, candyInit.weight);
        this.filling = candyInit.additional;
    }

    ChocolateCandy(String name, int sugarPercent, int weight, String filling) {
        super(name, sugarPercent, weight);
        this.filling = filling;
    }
}
