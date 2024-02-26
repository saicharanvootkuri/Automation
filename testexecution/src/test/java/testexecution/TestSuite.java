package testexecution;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestSuite {

    @Test
    public void testAddition() {
        assertEquals(4, 2 + 2);  
    }

    @Test
    public void testSubtraction() {
        assertEquals(3, 4 - 4); 
    }
}
