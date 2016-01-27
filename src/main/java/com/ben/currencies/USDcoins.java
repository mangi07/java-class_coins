package com.ben.currencies;

import com.ben.Currency;

/**
 * Created by ben on 1/25/2016.
 */
public class USDcoins extends Currency {
    public USDcoins() {
        coins = new int[]{100, 50, 25, 10, 5, 1};
        currencyCode = CoinType.USD;
    }
}
