package com.ben.currencies;

import com.ben.Currency;

/**
 * Created by ben on 1/25/2016.
 */
public class USDcoins extends Currency {
    USDcoins () {
        coins = new int[]{100, 50, 25, 10, 5, 1};
        currencyCode = "USD"; // maybe use enums instead
    }
}
