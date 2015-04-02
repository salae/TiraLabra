
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
public class PunamustaPuuTest {
    
    public PunamustaPuuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of hae method, of class PunamustaPuu.
     */
    @Test
    public void testHae() {
        System.out.println("hae");
        int avain = 5;
        PunamustaPuu instance = new PunamustaPuu();
        Solmu expResult = null;
        Solmu result = instance.hae(avain);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of lisaa method, of class PunamustaPuu.
//     */
//    @Test
//    public void testLisaa() {
//        System.out.println("lisaa");
//        int avain = 0;
//        PunamustaPuu instance = new PunamustaPuu();
//        instance.lisaa(avain);
//        Solmu expResult = new Solmu(0);
//        Solmu result = instance.hae(avain);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of poista method, of class PunamustaPuu.
//     */
//    @Test
//    public void testPoista() {
//        System.out.println("poista");
//        int avain = 0;
//        PunamustaPuu instance = new PunamustaPuu();
//        instance.poista(avain);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of tulostaPuu method, of class PunamustaPuu.
//     */
//    @Test
//    public void testTulostaPuu() {
//        System.out.println("tulostaPuu");
//        PunamustaPuu instance = new PunamustaPuu();
//        instance.lisaa(2);
//        String expResult = "2";
//        String result = instance.tulostaPuu();
//        assertEquals(expResult, result);
//    }
    
}
