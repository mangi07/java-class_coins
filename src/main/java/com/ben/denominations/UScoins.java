package com.ben.denominations;

import com.ben.Denomination;

/**
 * Created by ben on 1/22/2016.
 */
public class UScoins implements Denomination {

    private int[] coins = {100, 50, 25, 10, 5, 1};

    public int[] getCoins() {
        return coins;
    }
}
