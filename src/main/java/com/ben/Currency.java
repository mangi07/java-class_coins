package com.ben;

import com.ben.currencies.CoinType;

import java.util.Iterator;

/**
 * Created by ben on 1/22/2016.
 */
public abstract class Currency {

    protected int[] coins;
    protected CoinType currencyCode;

    public int[] getCoins() {
        return coins;
    }

    public CoinType getCurrencyCode() {
        return currencyCode;
    }

}
