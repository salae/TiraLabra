
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
//    public void testTeeLisays() {
          //toimii
//        System.out.println("teeLisays, binäärihakupuu");
//        Puu p = v.getViisto();
//        int lkm = 5;
//        int suurin = 8;
//        v.teeLisays(p, lkm, suurin);
//        ((BinHakupuu)p).tulosta(((BinHakupuu)p).getJuuri());        
//
////        int expResult = ;
////        int result = ;
////        assertEquals(expResult, result);
////        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testLaskeLisaystenKeskiarvo() {
//        //toimii
//        System.out.println("laskeLisaystenKeskiarvo");
//        Puu p = v.getPunamusta();
//        int lkm = 5;
//        int suurin = 8;
//        int kierros = 3;
//        v.laskeLisaystenKeskiarvo(p, lkm, suurin, kierros);
////        Vertailu instance = new Vertailu();
////        Long expResult = null;
////        Long result = instance.laskeLisaystenKeskiarvo(p, lkm, suurin, kierros);
////        assertEquals(expResult, result);
////        fail("The test case is a prototype.");
//    }
//    @Test
//    //toimii
//    public void testVertaileLisays() {
//        System.out.println("vertaileLisays");
//        int[] maarat = {3};
//        int maxi = 10;
//        int kertaa = 3;
//        v.vertaileLisays(maarat, maxi, kertaa);
//        v.getBinaari().tulosta(v.getBinaari().getJuuri());
////        Vertailu instance = new Vertailu();
////        instance.vertaileLisays(maarat, maxi, kertaa);
////        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testHaeLukuja() {
//        //toimii
//        System.out.println("haeLukuja");
//        v.alustaPuut(5, 5);
//        Puu p = v.getViisto();
//        int lkm = 3;
//        int suurin = 5;
//        v.haeLukuja(p, lkm, suurin);
////        Long expResult = null;
////        Long result = Vertailu.haeLukuja(p, lkm, suurin);
////        assertEquals(expResult, result);
////        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testLaskeHakujenKeskiarvo() {
//        //toimii
//        System.out.println("laskeHakujenKeskiarvo");
//        v.alustaPuut(5, 5);
//        Puu p = v.getPunamusta();
//        int lkm = 3;
//        int suurin = 5;
//        int kierros = 3;
//        v.laskeHakujenKeskiarvo(p, lkm, suurin, kierros);
////        Long expResult = null;
////        Long result = Vertailu.laskeHakujenKeskiarvo(p, lkm, suurin, kierros);
////        assertEquals(expResult, result);
////        fail("The test case is a prototype.");
//    }


//    @Test
//    public void testVertaileHaku() {
//        //toimii
//        System.out.println("vertaileHaku");
//        int[] maarat = {3};
//        int maxi = 10;
//        int kertaa = 3;  
//        
//        v.vertaileHaku(maarat, maxi, kertaa);
////        Vertailu instance = new Vertailu();
////        instance.vertaileHaku(maarat, maxi, kertaa);
////        fail("The test case is a prototype.");
//    }

    @Test
    public void testPoistaLukuja() {
        System.out.println("poistaLukuja");
        v.alustaPuut(10, 15);
//        Puu p = v.getViisto();
        Puu p = v.getPunamusta();
//        Puu p = v.getBinaari();
//        Puu p = v.getPuukeko();
        int lkm = 5;
        int suurin = 15;
        v.poistaLukuja(p, lkm, suurin);
        ((BinHakupuu)p).tulosta(((BinHakupuu)p).getJuuri());
        
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


//    @Test
//    public void testAlustaPuut() {
//        //toimii
//        System.out.println("alustaPuut");
//        int lkm = 5;
//        int suurin = 54;
//        v.alustaPuut(lkm, suurin);
//        v.getBinaari().tulosta(v.getBinaari().getJuuri());
//        v.getPunamusta().tulosta(v.getPunamusta().getJuuri());
//        v.getViisto().tulosta(v.getViisto().getJuuri());
//        v.getPuukeko().tulosta(v.getPuukeko().getJuuri());
////        Vertailu instance = new Vertailu();
////        instance.alustaPuut(lkm, suurin);
////        fail("The test case is a prototype.");
//    }
    
}
