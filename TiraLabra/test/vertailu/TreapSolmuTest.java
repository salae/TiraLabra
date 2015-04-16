
package vertailu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anu
 */
public class TreapSolmuTest {
    TreapSolmu trS;
    
    public TreapSolmuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        trS = new TreapSolmu(3);
    }
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void testGetPrioriteetti() {
//        System.out.println("getPrioriteetti");
//        TreapSolmu instance = null;
//        int expResult = 0;
//        int result = instance.getPrioriteetti();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testSetPrioriteetti() {
//        System.out.println("setPrioriteetti");
//        int prioriteetti = 0;
//        TreapSolmu instance = null;
//        instance.setPrioriteetti(prioriteetti);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    @Test
    public void testToString() {
        System.out.println("toString");
        trS.setPrioriteetti(512);
        System.out.println(trS);
        int expResult = 512;
        int result =trS.getPrioriteetti();
        assertEquals(expResult, result);
    }
    
}
