import com.ben.ChangeInput;
import org.junit.Test;

/**
 * Created by ben on 1/22/2016.
 */
public class ChangeInputTest {

    @Test
    public void parseShouldBeRejected () {
        ChangeInput changeInput = new ChangeInput();
        changeInput.getAmountInCents();
        // finish
    }

    @Test
    public void inputShouldBeTaken () {
        ChangeInput changeInput = new ChangeInput();
        changeInput.getChange();
    }
}
