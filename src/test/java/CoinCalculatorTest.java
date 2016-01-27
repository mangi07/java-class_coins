import com.ben.CoinCalculator;
import com.ben.currencies.CoinType;
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

        String coinMessage = coinCalculator.calculateChange(0, CoinType.USD);

        assertEquals("No coins returned", coinMessage);
    }

    @Test
    public void oneCentShouldGiveYouOnePenny() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange(1, CoinType.USD);

        assertEquals("1 coins", coinMessage);
    }

    @Test
    public void tenCentsShouldGiveYouOneDime() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange(10, CoinType.USD);

        assertEquals("1 coins", coinMessage);
    }

     @Test
    public void threeDollarsShouldGiveYouThreeCoins() {
        CoinCalculator coinCalculator = new CoinCalculator();

         String coinMessage = coinCalculator.calculateChange(300, CoinType.USD);

         assertEquals("3 coins", coinMessage);
    }

}
