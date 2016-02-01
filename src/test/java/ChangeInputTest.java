import com.ben.ChangeInputProcessor;
import com.ben.currencies.CoinType;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Created by ben on 1/22/2016.
 */
public class ChangeInputTest {

    ChangeInputProcessor changeInput;

    @Before
    public void setUp() throws Exception {
        changeInput = new ChangeInputProcessor();
    }

    @Test
    public void inputShouldBeRejected() {
        String[] inputSet = {"US", "0 USD", ".00 USD", "0.000 USD"};
        for (String input : inputSet) {
            changeInput.setInput(input);
            try {
                changeInput.parseInput();
                fail();
            } catch (IOException e) {
                // do nothing
            }
        }
    }

    @Test
    public void inputShouldBeTaken() throws IOException {
        String[] inputSet = {"0.00 USD", "3.01 USD", "33000.99 USD"};
        for (String input : inputSet) {
            changeInput.setInput(input);
            changeInput.parseInput();
        }
    }

    @Test
    public void inputShouldParseCorrectly() throws IOException {
        String[] inputSet = {"3.00 USD", "3.01 USD", "0.95 USD", "365.12 USD"};
        int[] correctCents = {300, 301, 95, 36512};
        for (int i = 0; i < inputSet.length; i++) {
            changeInput.setInput(inputSet[i]);
            changeInput.parseInput();
            assertEquals(changeInput.getCents(), correctCents[i]);
            assertEquals(changeInput.getCurrencyCode(), CoinType.USD);
        }
    }
}
