
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
public class BinHakupuuTest {
    
    public BinHakupuuTest() {
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
     * Test of getJuuri method, of class BinHakupuu.
     */
    @Test
    public void testGetJuuri() {
        System.out.println("getJuuri");
        BinHakupuu instance = new BinHakupuu();
        Solmu expResult = null;
        Solmu result = instance.getJuuri();
        assertEquals(expResult, result);
    }

    /**
     * Test of setJuuri method, of class BinHakupuu.
     */
    @Test
    public void testSetJuuri() {
        System.out.println("setJuuri");
        Solmu juuri = new Solmu(12);
        BinHakupuu instance = new BinHakupuu();
        instance.setJuuri(juuri);
        Solmu expResult = juuri;
        Solmu result = instance.getJuuri();
        assertEquals(expResult, result);
    }

    /**
     * Test of hae method, of class BinHakupuu.
     */
    @Test
    public void testHaeEiLoydy() {
        System.out.println("hae");
        int avain = 5;
        BinHakupuu instance = new BinHakupuu();
        Solmu expResult = null;
        Solmu result = instance.hae(avain);
        assertEquals(expResult, result);
    }

    /**
     * Test of lisaa method, of class BinHakupuu.
     */
    @Test
    public void testLisaa() {
        System.out.println("lisaa");
        int avain = 1;
        BinHakupuu instance = new BinHakupuu();
        instance.lisaa(avain);
        Solmu expResult = instance.getJuuri();
        Solmu result = instance.hae(avain);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of poista method, of class BinHakupuu.
//     */
//    @Test
//    public void testPoista() {
//        System.out.println("poista");
//        int avain = 0;
//        BinHakupuu instance = new BinHakupuu();
//        instance.poista(avain);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
