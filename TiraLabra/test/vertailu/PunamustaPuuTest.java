
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
    PunamustaPuu pmPuu;
    
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
        pmPuu = new PunamustaPuu();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLisaaSolmu() {
        System.out.println("lisaa Solmu");
        PmSolmu s1= new PmSolmu(3,true);
        PmSolmu s2 = new PmSolmu (4,true);
        pmPuu.lisaaSolmu(s1);
        pmPuu.lisaaSolmu(s2);
        System.out.println(s1);
        pmPuu.tulosta(pmPuu.getJuuri());
        Solmu expResult = s1;
        Solmu result = pmPuu.getJuuri();
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of hae method, of class PunamustaPuu.
     */
    @Test
    public void testHaeLoytyy() {
        System.out.println("hae, loytyy");
        PmSolmu s1 = new PmSolmu(4,true);
        PmSolmu s2 = new PmSolmu(2,true);
        pmPuu.lisaaSolmu(s1);        
        pmPuu.lisaaSolmu(s2);
        pmPuu.tulosta(pmPuu.getJuuri());
        Solmu expResult = s2;
        Solmu result = pmPuu.hae(2);
        assertEquals(expResult, result);
    }

    @Test
    public void testHaeEiLoydy() {
        System.out.println("hae, ei loydy");
        PmSolmu s1 = new PmSolmu(4,true);
        PmSolmu s2 = new PmSolmu(2,true);
        pmPuu.lisaaSolmu(s1);        
        pmPuu.lisaaSolmu(s2);
        Solmu expResult = null;
        Solmu result = pmPuu.hae(1);
        assertEquals(expResult, result);
    }   

    @Test
    public void testLisaa() {
        System.out.println("lisaa");
        int avain = 1;
        pmPuu.lisaa(avain);
        Solmu expResult = pmPuu.getJuuri();
        Solmu result = pmPuu.hae(avain);
        assertEquals(expResult, result);
    }

//    @Test
//    public void testPoista() {
//        System.out.println("poista");
//        int avain = 0;
//        PunamustaPuu instance = new PunamustaPuu();
//        instance.poista(avain);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
