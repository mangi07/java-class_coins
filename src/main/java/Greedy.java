/**
 * User: Ben Olson
 * Modified from user mpmenne
 * Date: 1/18/16
 * Time: 2:45 PM
 */
public class Greedy {


    public static void main(String[] varArgs) {

        if (varArgs.length > 0) {
            CoinCalculator coinCalculator = new CoinCalculator();
            String changeMessage = coinCalculator.calculateChange(varArgs[0]);
            System.out.println(changeMessage);
        } else {
            throw new IllegalArgumentException("No value given");
        }

    }

}
