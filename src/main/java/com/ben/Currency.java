package com.ben;

/**
 * Created by ben on 1/22/2016.
 */
public class Currency {

    public Currency (int[] coins, String currencyCode) {
        this.coins = coins;
        this.currencyCode = currencyCode;
    }

    private int[] coins;
    private String currencyCode;

    public int[] getCoins() {
        return coins;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

}
