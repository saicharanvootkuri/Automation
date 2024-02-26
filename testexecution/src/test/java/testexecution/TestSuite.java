package testexecution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSuite {

    @Test
    public void testAddition() {
        assertEquals(4, 2 + 2);  
    }

    @Test
    public void testSubtraction() {
        assertEquals(6, 4 - 4);
    }
}
