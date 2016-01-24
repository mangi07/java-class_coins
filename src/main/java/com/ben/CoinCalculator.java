package com.ben;

import java.util.ArrayList;

/**
 * User: Ben Olson
 * Modified from user mpmenne
 * Date: 1/18/16
 * Time: 2:45 PM
 */
public class CoinCalculator {


    public String calculateChange(String amountOfChange) {
        Currency c = CurrencyFactory.createCoins("USD");
        int[] coins = c.getCoins();
        for (int x = 0; x < coins.length; x++){
            while (change > coins[x]-1) {
                coins += change / coins[x];
                change = change % coins[x];
            }
        }
        if (coins > 0) {
            return coins + " coins";
        } else {
            return "No coins returned";
        }
    }
}
