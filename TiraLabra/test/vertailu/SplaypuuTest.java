
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
public class SplaypuuTest {
    
    Splaypuu splay;
    
    public SplaypuuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        splay = new Splaypuu();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testHaeEiLoydy() {
        System.out.println("haeEiLoydy");
        splay.lisaa(2);
        splay.lisaa(1);
        splay.lisaa(3);
        int avain = 5;
        Solmu expResult = null;
        Solmu result = splay.hae(avain);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHaeLoytyy() {
        System.out.println("haeLoytyy");
        splay.lisaa(2);
        splay.lisaa(1);
        splay.lisaa(3);
        int avain = 3;
        int expResult = 3;
        int result = splay.hae(avain).getAvain();
        assertEquals(expResult, result);
    }
    @Test
    public void testLisaa() {
        int avain = 1;
        splay.lisaa(avain);
        Solmu expResult = splay.getJuuri();
        Solmu result = splay.hae(avain);
        assertEquals(expResult, result);
    }

    @Test
    public void testPoista() {
        System.out.println("poista");
        splay.lisaa(3);
        splay.lisaa(4);
        splay.lisaa(6);
        splay.lisaa(1);
        splay.tulostaPuu(splay.getJuuri());
        splay.poista(4);
        splay.tulostaPuu(splay.getJuuri());
        System.out.println("juuri 4n poiston jälkeen:"+ splay.getJuuri());
        Solmu expResult = null;
        Solmu result =  splay.hae(4);
        assertEquals(expResult, result);
    }
    
}
