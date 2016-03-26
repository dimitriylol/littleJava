package org.media;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dmytro on 25.03.16.
 */
public class CandyBox {
    ArrayList<Candy> candies;

    public CandyBox(ArrayList<CandyInit> candyInits) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
        candies = new ArrayList<>();
        for (CandyInit candyInitValue : candyInits) {
            candies.add(candyInitValue.getCandy());
        }
    }

    public int totalWeight() {
        int res = 0;
        for (Candy candy : candies) {
            res += candy.getWeight();
        }
        return res;
    }

    public void sortCandiesByWeight() {
        Collections.sort(candies);
    }

    public Candy findCandyBySugarPercent(int sugarPercentLow, int sugarPercentHigh) {
        Candy res = null;
        for (Candy candy : candies) {
            if (candy.getSugarPercent() >= sugarPercentLow && candy.getSugarPercent() <= sugarPercentHigh) {
                res = candy;
                break;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        String res = "CandyBox consists of :\n";
        for (Candy candy : candies) {
            res += "\t* " + candy + "\n";
        }
        return res;
    }
}
