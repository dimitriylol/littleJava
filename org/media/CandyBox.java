package org.media;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dmytro on 25.03.16.
 */
public class CandyBox {
    ArrayList<Candy> candies;

    CandyBox(CandyInit[] candyInits) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
        candies = new ArrayList<>();
        for (CandyInit candyInitValue : candyInits) {
            addCandy(getCandyConstructor(candyInitValue.kind), candyInitValue);
        }
    }

    private Constructor getCandyConstructor(String candyKind) throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName(candyKind).getConstructor(CandyInit.class);
    }

    private void addCandy(Constructor constr, CandyInit candyInit) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        candies.add((Candy) constr.newInstance(candyInit));
//        candies.add((Candy) constr.newInstance(candyName, select.getInt("sugarPercent"),
//                select.getInt("weight"), select.getString("additional")));

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
            if (candy.getSugarPercent() >= sugarPercentLow && candy.getSugarPercent() <= sugarPercentLow) {
                res = candy;
                break;
            }
        }
        return res;
    }
}
