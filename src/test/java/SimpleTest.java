import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: Ben Olson
 * Modified from user mpmenne
 * Date: 1/18/16
 * Time: 2:45 PM
 */
public class SimpleTest {

    @Test
    public void testOneEqualsOne() {
        assertEquals(1, 1);
    }

    @Test
    public void testStringOneEqualsStringTwo() {
        assertEquals("one", "one");
    }

}
