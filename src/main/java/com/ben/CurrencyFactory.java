package com.ben;

import com.ben.currencies.CoinType;
import com.ben.currencies.EUcoins;
import com.ben.currencies.USDcoins;

/**
 * Created by ben on 1/22/2016.
 */
public class CurrencyFactory {

    private static Currency d = null;

    public static Currency createCoins(CoinType coinType) throws IllegalArgumentException {
        switch (coinType) {
            case USD:
                d = new USDcoins();
                break;
            case EU:
                d = new EUcoins();
                break;
            default:
                throw new IllegalArgumentException("Invalid currency code");
        }

        return d;
    }
}
