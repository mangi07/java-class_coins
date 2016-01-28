import com.ben.ChangeInputProcessor;
import junit.framework.Assert;
import org.junit.Test;
import java.io.IOException;
import static junit.framework.TestCase.fail;

/**
 * Created by ben on 1/22/2016.
 */
public class ChangeInputTest {

    @Test
    public void setUp() {
        System.out.println("setUP");
    }

    @Test
    public void parseShouldBeRejected() {
        ChangeInputProcessor changeInput = new ChangeInputProcessor();
        String[] inputSet = {"UD", "0 USD", ".00 USD", "0.000 USD", "0.00 USD"};
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
    public void inputShouldBeTaken() {
        ChangeInputProcessor changeInput = new ChangeInputProcessor();
        changeInput.getCents();
    }
}
