
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
public class PmSolmuTest {
    
    PmSolmu pm;
    
    public PmSolmuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pm = new PmSolmu(5, true);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testOnkoPunainen() {
        System.out.println("onkoPunainen");
        boolean expResult = true;
        boolean result = pm.onkoPunainen();
        assertEquals(expResult, result);
    }

    @Test
    public void testAsetaVari() {
        System.out.println("asetaVari");
        pm.asetaVari(false);
        boolean expResult = false;
        boolean result = pm.onkoPunainen();
        assertEquals(expResult,result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        System.out.println(pm);
        String expResult = "5 (punainen)";
        String result = pm.toString();
        assertEquals(expResult, result);
    }
    
}
