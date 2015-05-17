
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
        pmPuu.lisaa(2);
        int expResult = 2;
        int result = pmPuu.hae(2).getAvain();
        assertEquals(expResult, result);
    }

    @Test
    public void testHaeEiLoydy() {
        System.out.println("hae, ei loydy");
        pmPuu.lisaa(4);        
        pmPuu.lisaa(2);
        int expResult = -1;
        int result = pmPuu.hae(1).getAvain();
        assertEquals(expResult, result);
    }   

    @Test
    public void testLisaa() {
        System.out.println("lisaa");
        int avain = 3;
        pmPuu.lisaa(avain);        
        pmPuu.lisaa(5);
        pmPuu.lisaa(7);
        pmPuu.lisaa(1);
        pmPuu.tulostaPuu(pmPuu.getJuuri());        
        String expResult = "5 (musta)";
        String result =  pmPuu.getJuuri().toString();
        assertEquals(expResult, result);
    }
    @Test
    public void testhaeMin() {
        System.out.println("minimi");
        pmPuu.lisaa(5);
        pmPuu.lisaa(1);
        pmPuu.lisaa(2);
        int expResult = 1;
        int result = pmPuu.haeMin(pmPuu.getJuuri()).getAvain();
        assertEquals(expResult, result);
    }
     @Test
    public void testhaeMax() {
        System.out.println("maksimi");
        pmPuu.lisaa(5);
        pmPuu.lisaa(1);
        pmPuu.lisaa(2);
        int expResult = 5;
        int result = pmPuu.haeMax(pmPuu.getJuuri()).getAvain();
        assertEquals(expResult, result);
    }   
    @Test
    public void testPoista() {
        System.out.println("poista");
        pmPuu.lisaa(3);
        pmPuu.lisaa(4);
        pmPuu.lisaa(6);
        pmPuu.lisaa(1);
        pmPuu.tulostaPuu(pmPuu.getJuuri()); 
        System.out.println("juuri "+pmPuu.getJuuri());
        pmPuu.poista(4);        
        pmPuu.tulostaPuu(pmPuu.getJuuri());
        int expResult = -1;
        int result = pmPuu.hae(4).getAvain();
        assertEquals(expResult, result);
    }
     @Test
    public void testTyhjennaPuu() {
        System.out.println("tyhjennä puu");
        pmPuu.lisaa(3);
        pmPuu.lisaa(4);
        pmPuu.lisaa(6);
        pmPuu.lisaa(1);
        pmPuu.tyhjennaPuu(pmPuu.getJuuri());
        int expResult = -1;
        int result =  pmPuu.getJuuri().getAvain();
        assertEquals(expResult, result);

    }   
}
