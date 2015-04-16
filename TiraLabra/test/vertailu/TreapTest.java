
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
        Treap tr = new Treap();
    }
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void testHaeLoytyy() {
//        System.out.println("hae, loytyy");
//        TreapSolmu s1 = new TreapSolmu(4);
//        TreapSolmu s2 = new TreapSolmu(2);
//        tr.lisaaSolmu(s1);        
//        tr.lisaaSolmu(s2);
//        tr.tulosta(tr.getJuuri());
//        TreapSolmu expResult = s2;S
//        TreapSolmu result = tr.hae(2);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testHaeEiLoydy() {
//        System.out.println("hae, ei loydy");
//        PmSolmu s1 = new PmSolmu(4,true);
//        PmSolmu s2 = new PmSolmu(2,true);
//        tr.lisaaSolmu(s1);        
//        tr.lisaaSolmu(s2);
//        TreapSolmu expResult = null;
//        TreapSolmu result = tr.hae(1);
//        assertEquals(expResult, result);
//    }   

//
//    @Test
//    public void testLisaa() {
//        System.out.println("lisaa");
//        int avain = 0;
//        Treap instance = new Treap();
//        instance.lisaa(avain);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//
//    @Test
//    public void testPoista() {
//        System.out.println("poista");
//        int avain = 0;
//        Treap instance = new Treap();
//        instance.poista(avain);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
