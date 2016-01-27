package com.ben;

import com.ben.currencies.CoinType;

import java.io.IOException;

/**
 * User: Ben Olson
 * Modified from user mpmenne
 * Date: 1/18/16
 * Time: 2:45 PM
 */
public class Greedy {


    public static void main(String[] varArgs) {

        CoinCalculator coinCalculator = new CoinCalculator();
        ChangeInputProcessor inputProcessor = new ChangeInputProcessor();

        inputProcessor.getUserInput();
        try {
            inputProcessor.parseInput();
        } catch (IOException ioe) {
            ioe.getMessage();
            System.exit(1);
        } catch (IllegalArgumentException iae) {
            iae.getMessage();
            System.exit(1);
        }

        int amountInCents = inputProcessor.getCents();
        CoinType currency = inputProcessor.getCurrencyCode();
        String changeMessage = coinCalculator.calculateChange(amountInCents, currency);
        System.out.println(changeMessage);

    }

}
