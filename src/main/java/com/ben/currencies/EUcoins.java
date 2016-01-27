package com.ben.currencies;

import com.ben.Currency;

/**
 * Created by ben on 1/27/2016.
 */
public class EUcoins extends Currency {
    public EUcoins() {
        coins = new int[]{200, 100, 50, 20, 10, 5, 2, 1};
        currencyCode = CoinType.EU;
    }
}
