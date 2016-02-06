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

    public ChangeInputProcessor() {

        pattern = Pattern.compile(CURRENCY_REGEX);

    }

    private static final String CURRENCY_REGEX =
            String.format("^(\\d+)\\.(\\d{2})\\s(%s)$", coinTypes());

    private static String coinTypes() {
        StringBuilder builder = new StringBuilder();
        for (CoinType currencyCode : CoinType.values()) {
            builder.append("(" + currencyCode + ")|");
        }
        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    private static final String USER_PROMPT = userPrompt();

    private static String userPrompt() {
        StringBuilder builder = new StringBuilder();

        builder.append("Please enter change as x.xx <currency code>.\n");
        builder.append("Use one of the following currencies:\n");
        for (CoinType currencyCode : CoinType.values()) {
            builder.append(currencyCode + "\n");
        }
        builder.append("For example: 365.12 " + CoinType.values()[0] + "\n");

        return builder.toString();

    }

    private Pattern pattern;
    private Matcher matcher;

    private CoinType currencyCode;
    private int cents = -1;
    private String inputString;

    public void getUserInput() {
        Scanner in = new Scanner(System.in);
        System.out.println(USER_PROMPT);
        inputString = in.nextLine();
        matcher = pattern.matcher(inputString);
    }

    public void parseInput() throws IOException, IllegalArgumentException {

        if (matcher == null) {
            throw new IOException(
                    "Error in parseInput(): no input set");
        }
        if (matcher.matches()) {
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

    public int getCents() {
        return cents;
    }

    /* Methods used for testing */
    public CoinType getCurrencyCode() {
        return currencyCode;
    }

    public void setInput(String s) {
        inputString = s;
        matcher = pattern.matcher(inputString);
    }
}
