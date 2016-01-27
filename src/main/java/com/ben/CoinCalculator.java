package com.ben;

import com.ben.currencies.CoinType;

import java.util.ArrayList;

/**
 * User: Ben Olson
 * Modified from user mpmenne
 * Date: 1/18/16
 * Time: 2:45 PM
 */
public class CoinCalculator {


    public String calculateChange(int amountInCents, CoinType currencyCode) {
        Currency c = CurrencyFactory.createCoins(currencyCode);
        int coinCount = 0;
        int[] coins = c.getCoins();
        for (int x = 0; x < coins.length; x++){
            while (amountInCents > coins[x]-1) {
                coinCount += amountInCents / coins[x];
                amountInCents = amountInCents % coins[x];
            }
        }
        if (coinCount > 0) {
            return coins + " coins";
        } else {
            return "No coins returned";
        }
    }
}
