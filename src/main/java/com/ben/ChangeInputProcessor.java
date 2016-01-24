package com.ben;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ben on 1/22/2016.
 */
public class ChangeInputProcessor {

    public ChangeInputProcessor () {
        String[] currencyCodes = CurrencyFactory.getCurrencyCodeList();
        StringBuilder builder = new StringBuilder("^(\\d+)\\.(\\d{2})\\s(");
        for (String currencyCode: currencyCodes) {
            builder.append("(" + currencyCode + ")|");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")$");
        CURRENCY_REGEX = builder.toString();
        pattern = Pattern.compile(CURRENCY_REGEX);
        matcher = pattern.matcher(inputString);

        builder.delete(0, builder.length());
        builder.append("Please enter change as x.xx <currency code>.\n");
        builder.append("Use one of the following currencies:\n");
        for (String currencyCode: currencyCodes) {
            builder.append(currencyCode + "\n");
        }
        builder.append("For example: 365.12 " + currencyCodes[0] + "\n");
        userPrompt = builder.toString();
    }
    private String CURRENCY_REGEX;
    private Pattern pattern;
    private Matcher matcher;

    private String currencyCode;
    private int cents = -1;
    private String inputString;
    String userPrompt;

    public void getUserInput () {
        Scanner in = new Scanner(System.in);
        System.out.println(userPrompt);
        inputString = in.nextLine();
    }

    public void parseInput () throws IOException {

        if (matcher.matches()){
            cents = 0;
            String left = matcher.group(0);
            String right = matcher.group(1);

            cents += Integer.parseInt(left) * 100;
            cents += Integer.parseInt(right);
            currencyCode = matcher.group(2).toLowerCase();
        } else {
            throw new IOException("Invalid format: " + inputString);
        }
    }

    public int getCents () {
        return cents;
    }

    public String getCurrencyCode () {
        return currencyCode;
    }

    public String getCURRENCY_REGEX () {
        return CURRENCY_REGEX;
    }

}
