package com.ben;

import com.ben.currencies.CoinType;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ben on 1/22/2016.
 */
public class ChangeInputProcessor {

    public ChangeInputProcessor () {
        StringBuilder builder = new StringBuilder("^(\\d+)\\.(\\d{2})\\s(");
        for (CoinType currencyCode : CoinType.values()) {
            builder.append("(" + currencyCode + ")|");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")$");
        CURRENCY_REGEX = builder.toString();
        pattern = Pattern.compile(CURRENCY_REGEX);

        builder.delete(0, builder.length());
        builder.append("Please enter change as x.xx <currency code>.\n");
        builder.append("Use one of the following currencies:\n");
        for (CoinType currencyCode : CoinType.values()) {
            builder.append(currencyCode + "\n");
        }
        builder.append("For example: 365.12 " + CoinType.values()[0] + "\n");
        userPrompt = builder.toString();
    }
    private String CURRENCY_REGEX;
    private Pattern pattern;
    private Matcher matcher;

    private CoinType currencyCode;
    private int cents = -1;
    private String inputString;
    String userPrompt;

    public void getUserInput () {
        Scanner in = new Scanner(System.in);
        System.out.println(userPrompt);
        inputString = in.nextLine();
        matcher = pattern.matcher(inputString);
    }

    public void parseInput() throws IOException, IllegalArgumentException {

        if (matcher == null) {
            throw new IOException(
                    "Error in parseInput(): no input set");
        }
        if (matcher.matches()){
            cents = 0;
            String left = matcher.group(1);
            String right = matcher.group(2);

            cents += Integer.parseInt(left) * 100;
            cents += Integer.parseInt(right);
            String strCode = matcher.group(3).toUpperCase();
            currencyCode = CoinType.valueOf(strCode);
        } else {
            throw new IOException("Invalid format: " + inputString);
        }
    }

    public int getCents () {
        return cents;
    }

    /* Methods used for testing */
    public CoinType getCurrencyCode() {
        return currencyCode;
    }

    public String getCURRENCY_REGEX () {
        return CURRENCY_REGEX;
    }

    public void setInput(String s) {
        inputString = s;
        matcher = pattern.matcher(inputString);
    }
}
