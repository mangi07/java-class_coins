package com.ben;

import com.ben.denominations.EUcoins;
import com.ben.denominations.UScoins;

/**
 * Created by ben on 1/22/2016.
 */
public class DenominationFactory {
    private static Denomination d;

    public static Denomination createCoins(String currency) {
        if (currency.equals("USD")) {
            d = new UScoins();
       } else if (currency.equals("EU")) {
            d = new EUcoins();
       }
        return d;
    }
}
