import java.util.ArrayList;

/**
 * User: Ben Olson
 * Modified from user mpmenne
 * Date: 1/18/16
 * Time: 2:45 PM
 */
public class CoinCalculator {


    public String calculateChange(String amountOfChange) {
        int change = Integer.parseInt(amountOfChange.substring(amountOfChange.length() - 2));
        change += 100*Integer.parseInt(
                amountOfChange.substring(0, amountOfChange.length() - 3));
        int coins = 0;
        int[] USdenomination = {100, 50, 25, 10, 5, 1};
        int[] EUdenomination = {200, 100, 50, 20, 10, 5, 2, 1};
        for (int x = 0; x < USdenomination.length; x++){
            while (change > USdenomination[x]-1) {
                coins += change / USdenomination[x];
                change = change % USdenomination[x];
            }
        }
        if (coins > 0) {
            return coins + " coins";
        } else {
            return "No coins returned";
        }
    }
}
