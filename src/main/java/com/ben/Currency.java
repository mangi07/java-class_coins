package com.ben;

import java.util.Iterator;

/**
 * Created by ben on 1/22/2016.
 */
public abstract class Currency {

    protected int[] coins;
    protected String currencyCode;

    public int[] getCoins() {
        return coins;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

}
