package com.ben;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ben on 1/22/2016.
 */
public class ChangeInput {

    private String currencyCode;
    private int cents = -1;
    private String inputString;
    private String[] inputSplit;

    private Scanner in = new Scanner(System.in);
    private final Pattern currencyRegex =
            Pattern.compile("^\\d+\\.\\d\\d\\s(USD)|(EU)|(usd)|(eu)$");

    String userPrompt = "Please enter change as (x.xx USD) or (x.xx EU): ";

    public void getUserInput () throws IOException {
        System.out.println(userPrompt);
        inputString = in.nextLine();
        try {
            parseInput();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            System.exit(-1);
        }
    }

    public int getCents () {
        return cents;
    }

    private void parseInput () throws IOException {
        Matcher;
        if (inputString.matches(currencyRegex)){
           inputSplit = inputString.split("\\s");

        } else {
            throw new IOException("Invalid format: " + inputString);
        }

        if (inputSplit.length == 2){
            cents =
        }
    }

    /*
    private Printer getPrintStrategy() {

        while (true) {
            System.out.printf("Please enter 1 or 2:%n" +
                    "1. Print pyramid to file.%n" +
                    "2. Print pyramid to console output.%n");

            inputString = in.nextLine();

            if (inputString.equals("1")) {
                return new FileOutput();
            }
            else if (inputString.equals("2")) {
                return new ConsoleOutput();
            }

            System.out.printf("Invalid input: " + inputString
                    + "%n%nWould you like to try again (y/n)?  ");
            inputString = in.nextLine();
            if (inputString.equals("n")) {
                System.exit(1);
            }
        }
    }
  */

}
