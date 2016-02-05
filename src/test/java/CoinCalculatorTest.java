import com.ben.CoinCalculator;
import com.ben.currencies.CoinType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


/**
 * User: Ben Olson
 * Modified from user mpmenne
 * Date: 1/18/16
 * Time: 2:45 PM
 */
public class CoinCalculatorTest {

    CoinCalculator coinCalculator;

    @Before
    public void setUp() {

        coinCalculator = new CoinCalculator();

    }


    /* USD coin tests */
    @Test
    public void zeroUSDCentMeansYouGetZeroCoins() {

        String coinMessage = coinCalculator.calculateChange(0, CoinType.USD);
        assertEquals("No coins returned", coinMessage);

    }

    @Test
    public void seventeenUSDCentsMeansYouGetFourCoins() {

        String coinMessage = coinCalculator.calculateChange(17, CoinType.USD);
        assertEquals("4 coins", coinMessage);

    }

    @Test
    public void twentyFiveUSDCentsMeansYouGetOneCoin () {

        String coinMessage = coinCalculator.calculateChange(25, CoinType.USD);
        assertEquals("1 coins", coinMessage);

    }

    @Test
    public void oneHundredEightyUSDCentsMeansYouGetFourCoins () {

        String coinMessage = coinCalculator.calculateChange(180, CoinType.USD);
        assertEquals("4 coins", coinMessage);

    }

    @Test
    public void threeHundredOneUSDCentsMeansYouGetFourCoins () {

        String coinMessage = coinCalculator.calculateChange(301, CoinType.USD);
        assertEquals("4 coins", coinMessage);

    }




    /* EU coin tests */
    @Test
    public void zeroEUCentMeansYouGetZeroCoins () {

        String coinMessage = coinCalculator.calculateChange(0, CoinType.EU);
        assertEquals("No coins returned", coinMessage);

    }

    @Test
    public void seventeenEUCentsMeansYouGetThreeCoins() {

        String coinMessage = coinCalculator.calculateChange(17, CoinType.EU);
        assertEquals("3 coins", coinMessage);

    }

    @Test
    public void twentyFiveEUCentsMeansYouGetTwoCoins() {

        String coinMessage = coinCalculator.calculateChange(25, CoinType.EU);
        assertEquals("2 coins", coinMessage);

    }

    @Test
    public void oneHundredEightyEUCentsMeansYouGetFourCoins() {

        String coinMessage = coinCalculator.calculateChange(180, CoinType.EU);
        assertEquals("4 coins", coinMessage);

    }

    @Test
    public void threeHundredOneEUCentsMeansYouGetThreeCoins () {

        String coinMessage = coinCalculator.calculateChange(301, CoinType.EU);
        assertEquals("3 coins", coinMessage);

    }

}
