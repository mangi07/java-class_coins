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

    ArrayList<int[]> changeArrays = new ArrayList<int[]>();
    ArrayList<int[]> coinsArrays = new ArrayList<int[]>();
    CoinCalculator coinCalculator;

    @Before
    public void setUp() {

        coinCalculator = new CoinCalculator();
        int[] USDchange =        {1, 4, 5, 9, 10, 11, 15, 25, 51, 52, 79, 100, 179};
        int[] USDcoinsReturned = {1, 4, 1, 5,  1,  2,  2,  1,  2,  3,  6,   1,   7};

        int[] EUchange =        {1, 2, 3, 5, 12, 14, 19, 20, 70, 160, 262};
        int[] EUcoinsReturned = {1, 1, 2, 1,  2,  3,  4,  1,  2,   3,   4};

        assertEquals(USDchange.length, USDcoinsReturned.length);
        changeArrays.add(USDchange);
        coinsArrays.add(USDcoinsReturned);

        assertEquals(EUchange.length, EUcoinsReturned.length);
        changeArrays.add(EUchange);
        coinsArrays.add(EUcoinsReturned);

    }

    @Test
    public void shouldReturnCorrectCoins() {

        assertEquals(changeArrays.size(), coinsArrays.size());
        CoinType[] coinType = CoinType.values();

        int amount;
        int actualCoins, correctCoins;

        for (int i = 0; i < changeArrays.size(); i++) {

            int[] amountTestSet = changeArrays.get(i);
            int[] coinsTestSet = coinsArrays.get(i);

            for (int j = 0; j < amountTestSet.length; j++) {
                amount = amountTestSet[j];
                actualCoins = coinsTestSet[j];
                coinCalculator.calculateChange(amount, coinType[i]);
                correctCoins = coinCalculator.getCoinCount();
                assertEquals(actualCoins, correctCoins);
            }
        }

    }

    @Test
    public void zeroChangeMeansYouGetZeroCoins() {

        String coinMessage = coinCalculator.calculateChange(0, CoinType.USD);
        assertEquals("No coins returned", coinMessage);

        coinMessage = coinCalculator.calculateChange(0, CoinType.EU);
        assertEquals("No coins returned", coinMessage);
    }


}
