
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
    public void testGetJuuriNil() {
        System.out.println("getJuuriNil");
        int expResult = -1;
        int result = pmPuu.getJuuri().getAvain();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetJuuriNotNull() {
        System.out.println("getJuuriNotNull");
        pmPuu.lisaa(4);
        int expResult = 4;
        int result = pmPuu.getJuuri().getAvain();
        assertEquals(expResult, result);
    }

    @Test
    public void testHaeLoytyy() {
        System.out.println("hae, loytyy");
        pmPuu.lisaa(4); 
        System.out.println(pmPuu.getJuuri());
        pmPuu.lisaa(2);
        pmPuu.tulosta(pmPuu.getJuuri());
        int expResult = 2;
        int result = pmPuu.hae(2).getAvain();
        assertEquals(expResult, result);
    }

    @Test
    public void testHaeEiLoydy() {
        System.out.println("hae, ei loydy");
        pmPuu.lisaa(4);        
        pmPuu.lisaa(2);
        Solmu expResult = null;
        Solmu result = pmPuu.hae(1);
        assertEquals(expResult, result);
    }   

    @Test
    public void testLisaa() {
        //käyty lisäksi paperin ja kynän kanssa läpi :)
        System.out.println("lisaa");
        int avain = 1;
        pmPuu.lisaa(avain);
        pmPuu.lisaa(7);
        pmPuu.lisaa(5);
        pmPuu.tulosta(pmPuu.getJuuri()); 
        String expResult = "5 (musta)";
        String result =  pmPuu.getJuuri().toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testPoista() {
        System.out.println("poista");
        pmPuu.lisaa(3);
        pmPuu.lisaa(4);
        pmPuu.lisaa(6);
        pmPuu.lisaa(1);
        pmPuu.tulosta(pmPuu.getJuuri());
        pmPuu.poista(4);
        pmPuu.tulosta(pmPuu.getJuuri());
        Solmu expResult = null;
        Solmu result =  pmPuu.hae(4);
        assertEquals(expResult, result);

    }
    
}
