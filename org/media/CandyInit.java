package org.media;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by dmytro on 26.03.16.
 */
public class CandyInit {
    public final String additional;
    public final String name;
    public final int sugarPercent;
    public final int weight;
    private final String kind;

    public CandyInit(String name, int sugarPercent, int weight, String kind, String additional) {
        this.name = name;
        this.sugarPercent = sugarPercent;
        this.weight = weight;
        this.additional = additional;
        this.kind = kind;
    }

    private Constructor<Candy> getCandyConstructor() throws ClassNotFoundException, NoSuchMethodException {
        Class<CandyInit> ci = CandyInit.class;
        return (Constructor<Candy>) Class.forName("org.media." + this.kind).getConstructor(ci);
    }

    public Candy getCandy() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        return getCandyConstructor().newInstance(this);
    }
}
