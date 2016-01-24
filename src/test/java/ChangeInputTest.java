import com.ben.ChangeInputProcessor;
import org.junit.Test;

/**
 * Created by ben on 1/22/2016.
 */
public class ChangeInputTest {

    @Test
    public void parseShouldBeRejected () {
        ChangeInputProcessor changeInput = new ChangeInputProcessor();


        // finish
    }

    @Test
    public void inputShouldBeTaken () {
        ChangeInputProcessor changeInput = new ChangeInputProcessor();
        changeInput.getCents();
    }
}
