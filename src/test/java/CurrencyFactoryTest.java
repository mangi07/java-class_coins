import com.ben.Currency;
import com.ben.CurrencyFactory;
import com.ben.currencies.CoinType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ben on 1/30/2016.
 */
public class CurrencyFactoryTest {
    @Test
    public void shouldCreateCoins () {
        Currency c = CurrencyFactory.createCoins(CoinType.EU);
        assertEquals(c.getCurrencyCode(),CoinType.EU);

        Currency d = CurrencyFactory.createCoins(CoinType.USD);
        assertEquals(d.getCurrencyCode(),CoinType.USD);
    }
}
