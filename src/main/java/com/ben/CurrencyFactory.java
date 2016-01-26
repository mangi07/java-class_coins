package com.ben;

/**
 * Created by ben on 1/22/2016.
 */
public class CurrencyFactory {

    private static String[] currencyCodeList = {"USD", "EU"};
    private static Currency d;

    public static String[] getCurrencyCodeList() {
        return  currencyCodeList;
    }
    public static Currency createCoins(String currency) throws IllegalArgumentException {
        if (currency.equals("USD")) {
            d = new Currency(
            );
       } else if (currency.equals("EU")) {
            d = new Currency(
                    new int[]{200, 100, 50, 20, 10, 5, 2, 1}, "EU"
            );
       } else {
            throw new IllegalArgumentException("Invalid currency code");
        }
        return d;
    }
}
