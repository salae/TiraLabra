
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
public class TreapTest {
    Treap tr;
    
    public TreapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tr = new Treap();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testHaeLoytyy() {
        System.out.println("hae, loytyy");
        TreapSolmu s1 = new TreapSolmu(4);
        TreapSolmu s2 = new TreapSolmu(2);
        tr.lisaaSolmu(s1);        
        tr.lisaaSolmu(s2);
        tr.tulosta(tr.getJuuri());
        TreapSolmu expResult = s2;
        TreapSolmu result = tr.hae(2);
        assertEquals(expResult, result);
    }

    @Test
    public void testHaeEiLoydy() {
        System.out.println("hae, ei loydy");
        TreapSolmu s1 = new TreapSolmu(4);
        TreapSolmu s2 = new TreapSolmu(2);
        tr.lisaaSolmu(s1);        
        tr.lisaaSolmu(s2);
        TreapSolmu expResult = null;
        TreapSolmu result = tr.hae(1);
        assertEquals(expResult, result);
    }   


    @Test
    public void testLisaa() {
        System.out.println("lisaa");
        int avain = 5;
        tr.lisaa(avain);
        tr.tulosta(tr.getJuuri());
        int expResult = avain;
        int result = tr.getJuuri().getAvain();
        assertEquals(expResult, result);
    }
    @Test
    public void testPoistaTesti1() {
        System.out.println("poista, testi1");
        tr.lisaa(3);
        tr.lisaa(4);
        tr.lisaa(1);
        tr.tulosta(tr.getJuuri());
        tr.poista(3);
        tr.tulosta(tr.getJuuri());
        Solmu expResult = null;
        Solmu result =  tr.hae(3);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPoistaTesti2() {
        System.out.println("poista, testi2");
        tr.lisaa(3);
        tr.lisaa(4);
        tr.lisaa(1);
        tr.tulosta(tr.getJuuri());
        tr.poista(1);
        tr.tulosta(tr.getJuuri());
        Solmu expResult = null;
        Solmu result =  tr.hae(1);
        assertEquals(expResult, result);
    }
 
    @Test
    public void testPoistaTesti3() {
        System.out.println("poista, testi 3");
        tr.lisaa(3);
        tr.lisaa(4);
        tr.lisaa(6);
        tr.lisaa(1);
        tr.tulosta(tr.getJuuri());
        tr.poista(4);
        tr.tulosta(tr.getJuuri());
        Solmu expResult = null;
        Solmu result =  tr.hae(4);
        assertEquals(expResult, result);
    }
}
