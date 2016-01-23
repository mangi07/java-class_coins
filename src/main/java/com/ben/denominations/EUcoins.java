package com.ben.denominations;

import com.ben.Denomination;

/**
 * Created by ben on 1/22/2016.
 */
public class EUcoins implements Denomination {

    private int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};

    public int[] getCoins() {
        return coins;
    }
}
