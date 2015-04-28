
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
public class VertailuTest {
    Vertailu v;
    
    public VertailuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        v = new Vertailu();
    }
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void testVertaileLisays() {
//        System.out.println("vertaileLisays");
//        int[] maarat = {5,10};
//        int maxi = 25;
//        int kertaa = 1;
//        v.vertaileLisays(maarat, maxi, kertaa);
//        v.getBinaari().tulosta(v.getBinaari().getJuuri());
////        Vertailu instance = new Vertailu();
////        instance.vertaileLisays(maarat, maxi, kertaa);
////        fail("The test case is a prototype.");
//    }



//    @Test
//    public void testVertaileHaku() {
//        System.out.println("vertaileHaku");
//        int[] maarat = null;
//        int maxi = 0;
//        int kertaa = 0;
//        Vertailu instance = new Vertailu();
//        instance.vertaileHaku(maarat, maxi, kertaa);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testTeeLisays() {
//        System.out.println("teeLisays");
//        Puu p = null;
//        int lkm = 0;
//        int suurin = 0;
//        Long expResult = null;
//        Long result = Vertailu.teeLisays(p, lkm, suurin);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testLaskeLisaystenKeskiarvo() {
//        System.out.println("laskeLisaystenKeskiarvo");
//        Puu p = null;
//        int lkm = 0;
//        int suurin = 0;
//        int kierros = 0;
//        Long expResult = null;
//        Long result = Vertailu.laskeLisaystenKeskiarvo(p, lkm, suurin, kierros);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testHaeLukuja() {
//        System.out.println("haeLukuja");
//        Puu p = null;
//        int lkm = 0;
//        int suurin = 0;
//        Long expResult = null;
//        Long result = Vertailu.haeLukuja(p, lkm, suurin);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testLaskeHakujenKeskiarvo() {
//        System.out.println("laskeHakujenKeskiarvo");
//        Puu p = null;
//        int lkm = 0;
//        int suurin = 0;
//        int kierros = 0;
//        Long expResult = null;
//        Long result = Vertailu.laskeHakujenKeskiarvo(p, lkm, suurin, kierros);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
    
//     @Test
//    public void testVertailePoisto() {
////        v.alustaPuut(20, 25);
//        int[] maarat = {5,10};
//        int maxi = 25;
//        int kertaa = 1;
//
//        v.vertailePoisto(maarat, maxi, kertaa);
//        v.getBinaari().tulosta(v.getBinaari().getJuuri());
////        instance.vertailePoisto(maarat, maxi, kertaa);
////        fail("The test case is a prototype.");
//    }   
    @Test
    public void testPoistaLukuja() {
        System.out.println("poistaLukuja");
        v.alustaPuut(10, 2);
//        Puu p = v.getViisto();
        Puu p = v.getPunamusta();
        int lkm = 5;
        int suurin = 2;
        v.poistaLukuja(p, lkm, suurin);
        v.getBinaari().tulosta(v.getBinaari().getJuuri());
        
//        Long expResult = null;
//        Long result = Vertailu.poistaLukuja(p, lkm, suurin);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
    }

//    @Test
//    public void testLaskePoistojenKeskiarvo() {
//        System.out.println("laskePoistojenKeskiarvo");
//        Puu p = null;
//        int lkm = 0;
//        int suurin = 0;
//        int kierros = 0;
//        Long expResult = null;
//        Long result = Vertailu.laskePoistojenKeskiarvo(p, lkm, suurin, kierros);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
    
}
