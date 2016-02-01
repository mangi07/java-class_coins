package com.ben;

import com.ben.currencies.CoinType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * User: Ben Olson
 * Modified from user mpmenne
 * Date: 1/18/16
 * Time: 2:45 PM
 */
public class Greedy {

    ApplicationContext context;
    CoinCalculator coinCalculator;
    ChangeInputProcessor inputProcessor;

    public Greedy() {
        context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        coinCalculator =
                (CoinCalculator) context.getBean("coinCalculator");
        inputProcessor =
                (ChangeInputProcessor) context.getBean("inputProcessor");
    }

    public static void main(String[] varArgs) {

        Greedy greedy = new Greedy();

        greedy.getUserInput();
        greedy.calculateChange();

    }

    public void getUserInput() {
        this.inputProcessor.getUserInput();
        try {
            this.inputProcessor.parseInput();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            System.exit(1);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            System.exit(1);
        }
    }

    public void calculateChange() {
        int amountInCents = this.inputProcessor.getCents();
        CoinType currency = this.inputProcessor.getCurrencyCode();
        String changeMessage = this.coinCalculator.calculateChange(amountInCents, currency);
        System.out.println(changeMessage);
    }
}
