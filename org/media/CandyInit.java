package org.media;

/**
 * Created by dmytro on 26.03.16.
 */
public class CandyInit {
    public final String additional;
    public final String name;
    public final int sugarPercent;
    public final int weight;
    public final String kind;

    public CandyInit(String name, int sugarPercent, int weight, String kind, String additional) {
        this.name = name;
        this.sugarPercent = sugarPercent;
        this.weight = weight;
        this.additional = additional;
        this.kind = kind;
    }
}
