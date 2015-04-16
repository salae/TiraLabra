
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
