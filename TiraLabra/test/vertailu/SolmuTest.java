
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
public class SolmuTest {
    
    public SolmuTest() {
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
     * Test of getAvain method, of class Solmu.
     */
    @org.junit.Test
    public void testGetAvain() {
        System.out.println("getAvain");
        Solmu instance = new Solmu(3);
        int expResult = 3;
        int result = instance.getAvain();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAvain method, of class Solmu.
     */
    @org.junit.Test
    public void testSetAvain() {
        System.out.println("setAvain");
        int avain = 43;
        Solmu instance = new Solmu(3);
        instance.setAvain(avain);
        int expResult = avain;
        int result = instance.getAvain();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVasenLapsi method, of class Solmu.
     */
    @org.junit.Test
    public void testGetVasenLapsi() {
        System.out.println("getVasenLapsi");
        Solmu instance = new Solmu(8);
        Solmu expResult = null;
        Solmu result = instance.getVasenLapsi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVasenLapsi method, of class Solmu.
     */
    @org.junit.Test
    public void testSetVasenLapsi() {
        System.out.println("setVasenLapsi");
        Solmu vasenLapsi = new Solmu(1);
        Solmu instance = new Solmu(2);
        instance.setVasenLapsi(vasenLapsi);
        Solmu expResult = vasenLapsi;
        Solmu result = instance.getVasenLapsi();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOikeaLapsi method, of class Solmu.
     */
    @org.junit.Test
    public void testGetOikeaLapsi() {
        System.out.println("getOikeaLapsi");
        Solmu instance = new Solmu(2);
        Solmu oikea = new Solmu(5);
        instance.setOikeaLapsi(oikea);
        Solmu expResult = oikea;
        Solmu result = instance.getOikeaLapsi();
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of setOikeaLapsi method, of class Solmu.
//     */
//    @org.junit.Test
//    public void testSetOikeaLapsi() {
//        System.out.println("setOikeaLapsi");
//        Solmu oikeaLapsi = null;
//        Solmu instance = null;
//        instance.setOikeaLapsi(oikeaLapsi);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getVanhempi method, of class Solmu.
//     */
//    @org.junit.Test
//    public void testGetVanhempi() {
//        System.out.println("getVanhempi");
//        Solmu instance = null;
//        Solmu expResult = null;
//        Solmu result = instance.getVanhempi();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setVanhempi method, of class Solmu.
//     */
//    @org.junit.Test
//    public void testSetVanhempi() {
//        System.out.println("setVanhempi");
//        Solmu vanhempi = null;
//        Solmu instance = null;
//        instance.setVanhempi(vanhempi);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of toString method, of class Solmu.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        Solmu instance = new Solmu(5);
        String expResult = "5";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Solmu.
     */
    @org.junit.Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Solmu vertailtava = new Solmu(5);
        Solmu instance = new Solmu(2);
        int expResult = -3;
        int result = instance.compareTo(vertailtava);
        assertEquals(expResult, result);
    }
    
}
