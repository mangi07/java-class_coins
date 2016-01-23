import com.ben.CoinCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: Ben Olson
 * Modified from user mpmenne
 * Date: 1/18/16
 * Time: 2:45 PM
 */
public class CoinCalculatorTest {

    @Test
    public void zeroChangeMeansYouGetZeroCoins() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.00");

        assertEquals("No coins returned", coinMessage);
    }

    @Test
    public void oneCentShouldGiveYouOnePenny() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.01");

        assertEquals("1 coins", coinMessage);
    }

    @Test
    public void tenCentsShouldGiveYouOneDime() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.10");

        assertEquals("1 coins", coinMessage);
    }

     @Test
    public void threeDollarsShouldGiveYouThreeCoins() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$3.00");

        assertEquals("4 coins", coinMessage);
    }

}
