import com.ben.Denomination;
import com.ben.DenominationFactory;
import org.junit.Test;

/**
 * Created by ben on 1/22/2016.
 */
public class DenominationFactoryTest {

    @Test
    public void eurosShouldBeUsed(){
        Denomination d = DenominationFactory.createCoins("EU");
    }

    @Test
    public void usdShouldBeUsed(){
        Denomination d = DenominationFactory.createCoins("USD");
    }

}
