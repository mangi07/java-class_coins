import com.ben.Currency;
import com.ben.CurrencyFactory;
import com.ben.currencies.CoinType;
import org.junit.Test;

/**
 * Created by ben on 1/22/2016.
 */
public class DenominationFactoryTest {

    @Test
    public void eurosShouldBeUsed(){
        Currency d = CurrencyFactory.createCoins(CoinType.EU);
    }

    @Test
    public void usdShouldBeUsed(){
        Currency d = CurrencyFactory.createCoins(CoinType.USD);
    }

}
