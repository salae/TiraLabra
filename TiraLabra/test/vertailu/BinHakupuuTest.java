
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
    
    BinHakupuu bin;
    
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
        bin = new BinHakupuu();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetJuuriNull() {
        System.out.println("getJuuriNull");
        Solmu expResult = null;
        Solmu result = bin.getJuuri();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetJuuriNotNull() {
        System.out.println("getJuuriNotNull");
        bin.lisaa(4);
        int expResult = 4;
        int result = bin.getJuuri().getAvain();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetJuuri() {
        System.out.println("setJuuri");
        Solmu juuri = new Solmu(12);
        bin.setJuuri(juuri);
        Solmu expResult = juuri;
        Solmu result = bin.getJuuri();
        assertEquals(expResult, result);
    }

    @Test
    public void testHaeEiLoydy() {
        System.out.println("haeEiLoydy");
        int avain = 5;
        Solmu expResult = null;
        Solmu result = bin.hae(avain);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHaeLoytyy() {
        System.out.println("haeLoytyy");
        bin.lisaa(3);
        bin.lisaa(5);
        int avain = 5;
        int expResult = 5;
        int result = bin.hae(avain).getAvain();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLisaa() {
        System.out.println("lisaa");
        int avain = 1;
        bin.lisaa(avain);
        Solmu expResult = bin.getJuuri();
        Solmu result = bin.hae(avain);
        assertEquals(expResult, result);
    }
    @Test
    public void testhaeMin() {
        System.out.println("minimi");
        Solmu juuri = new Solmu(3);
        bin.lisaaSolmu(juuri);
        bin.lisaa(5);
        bin.lisaa(1);
        bin.lisaa(2);
        int expResult = 1;
        int result = bin.haeMin(juuri).getAvain();
        assertEquals(expResult, result);
    }
    
        @Test
        public void testhaeMax() {
        System.out.println("maksimi");
        Solmu juuri = new Solmu(3);
        bin.lisaaSolmu(juuri);
        bin.lisaa(5);
        bin.lisaa(1);
        bin.lisaa(2);
        int expResult = 5;
        int result = bin.haeMax(juuri).getAvain();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPoista2lasta() {
        System.out.println("poista, kaksi lasta");
        bin.tulostaPuu(bin.getJuuri());
        bin.lisaa(3);
        bin.lisaa(4);
        bin.lisaa(1);
        bin.tulostaPuu(bin.getJuuri());
        bin.poista(3);
        bin.tulostaPuu(bin.getJuuri());
        Solmu expResult = null;
        Solmu result =  bin.hae(3);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPoistaEiLapsia() {
        System.out.println("poista, ei lapsia");
        bin.lisaa(3);
        bin.lisaa(4);
        bin.lisaa(1);
        bin.tulostaPuu(bin.getJuuri());
        bin.poista(1);
        bin.tulostaPuu(bin.getJuuri());
        Solmu expResult = null;
        Solmu result =  bin.hae(1);
        assertEquals(expResult, result);
    }
 
    @Test
    public void testPoista1Lapsi() {
        System.out.println("poista, yksi lapsi");
        bin.lisaa(3);
        bin.lisaa(4);
        bin.lisaa(6);
        bin.lisaa(1);
        bin.tulostaPuu(bin.getJuuri());
        bin.poista(4);
        bin.tulostaPuu(bin.getJuuri());
        Solmu expResult = null;
        Solmu result =  bin.hae(4);
        assertEquals(expResult, result);
    }

    @Test
    public void testVaihdaAlipuuta() {
        System.out.println("vaihdaAlipuuta");
        bin.lisaa(2);
        Solmu eka = bin.getJuuri();
        Solmu toka = new Solmu(7);
        bin.lisaaSolmu(toka);  
        bin.vaihdaAlipuuta(eka, toka);
        Solmu expResult = toka;
        Solmu result = bin.getJuuri();
        assertEquals(expResult,result);

    }
    @Test
    public void testTyhjennaPuu() {
        System.out.println("tyhjennä puu");
        bin.lisaa(3);
        bin.lisaa(4);
        bin.lisaa(6);
        bin.lisaa(1);
        bin.tulostaPuu(bin.getJuuri());
        bin.tyhjennaPuu(bin.getJuuri());
        bin.tulostaPuu(bin.getJuuri());
        Solmu expResult = null;
        Solmu result =  bin.getJuuri();
        assertEquals(expResult, result);
    }
}
