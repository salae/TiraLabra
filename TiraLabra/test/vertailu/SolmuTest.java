
package vertailu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Solmu-luokan yksikkötestausta
 * 
 * @author Anu
 */
public class SolmuTest {
    
    Solmu solmu;
    
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
        solmu = new Solmu(3);
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
        int expResult = 3;
        int result = solmu.getAvain();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAvain method, of class Solmu.
     */
    @org.junit.Test
    public void testSetAvain() {
        System.out.println("setAvain");
        int avain = 43;
        solmu.setAvain(avain);
        int odotettu = avain;
        int tulos = solmu.getAvain();
        assertEquals(odotettu, tulos);
    }

    /**
     * Test of getVasenLapsi method, of class Solmu.
     */
    @org.junit.Test
    public void testGetVasenLapsi() {
        System.out.println("getVasenLapsi");
        Solmu expResult = null;
        Solmu result = solmu.getVasenLapsi();
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
        Solmu oikea = new Solmu(5);
        solmu.setOikeaLapsi(oikea);
        Solmu expResult = oikea;
        Solmu result = solmu.getOikeaLapsi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOikeaLapsi method, of class Solmu.
     */
    @org.junit.Test
    public void testSetOikeaLapsi() {
        System.out.println("setOikeaLapsi");
        Solmu oikeaLapsi = new Solmu(8);
        solmu.setOikeaLapsi(oikeaLapsi);
        assertEquals(solmu.getOikeaLapsi().getAvain(),oikeaLapsi.getAvain());
    }

    /**
     * Test of getVanhempi method, of class Solmu.
     */
    @org.junit.Test
    public void testGetVanhempi() {
        System.out.println("getVanhempi");
        Solmu instance = new Solmu(1);
        solmu.setVanhempi(instance);
        Solmu expResult = instance;
        Solmu result = solmu.getVanhempi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVanhempi method, of class Solmu.
     */
    @org.junit.Test
    public void testSetVanhempi() {
        System.out.println("setVanhempi");
        Solmu vanhempi = new Solmu(10);
        solmu.setVanhempi(vanhempi);
        Solmu expResult = vanhempi;
        Solmu result = solmu.getVanhempi();
        assertEquals(expResult, result);        
    }

    /**
     * Test of toString method, of class Solmu.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "3";
        System.out.println(solmu);
        String result = solmu.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Solmu.
     */
    @org.junit.Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Solmu vertailtava = new Solmu(5);
        int expResult = -2;
        int result = solmu.compareTo(vertailtava);
        assertEquals(expResult, result);
    }
    
}
