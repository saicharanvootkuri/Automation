package testexecution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSuite {

    @Test
    public void testAddition() {
        assertEquals(6, 2 + 2);  
    }

    @Test
    public void testSubtraction() {
        assertEquals(0, 4 - 4);
    }
    
    @Test
    public void testmultiplication(){
    	assertEquals(6, 2*3);
    }
    
    @Test
    public void testdivision(){
    	assertEquals(3, 9/3);
    }
}
