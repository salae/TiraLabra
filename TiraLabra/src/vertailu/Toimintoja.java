
package vertailu;

import java.util.Random;

/**
 * Kirjastoluokka, johon on kerätty vertailussa käytettäviä metodeja.
 * Niiden avulla voidaan tehdä useita operaatioita kerralla ja 
 * laskea niihin kulunutta aikaa.
 * 
 * @author Anu
 */
public class Toimintoja {
    
    /**
     * Lisää puuhun halutun määrän satunnaisia kokonaislukuja 
     * väliltä 1 - määritelty suurin luku.
     * 
     * @param p puu, johon lisäykset tehdään
     * @param lkm lisättävien lukujen määrä
     * @param suurin suurin lisättävä luku
     * @return aika, joka lisäyksiin on kulunut millisekunteina
     */
    public static Long teeLisays(Puu p, int lkm, int suurin){
        
        Long alkuAika = System.currentTimeMillis();
        Random r = new Random();

        for(int i=0; i < lkm; i++) {
            int luku = r.nextInt(suurin-1)+1;
             p.lisaa(luku);
        }
        return System.currentTimeMillis() - alkuAika;    
    }
     
    /**
     * Hakee puusta halutun määrän satunnaisia lukuja.
     * 
     * @param p puu, josta haut tehdään
     * @param lkm haettavien lukujen määrä
     * @param suurin suurin haettava luku
     * @return aika, joka hakemiseen on kulunut millisekunteina
     */
     public static Long haeLukuja(Puu p, int lkm, int suurin){
        
        Long alkuAika = System.currentTimeMillis();
        Random r = new Random();

        for(int i=0; i < lkm; i++) {
            int luku = r.nextInt(suurin-1)+1;
             p.hae(luku);
        }
        return System.currentTimeMillis() - alkuAika;    
    } 
     
     /**
     * Poistaa puusta halutun määrän satunnaisia lukuja.
     * 
     * Ennen poistamista täytyy solmu etsiä, joten kyseessä on 
     * oikeastaan kaksi operaatiota: haku ja poisto. 
     * Jos luvun sisältämää solmua ei löydy, ei tehdä mitään.
     * 
     * @param p puu, josta poistot tehdään
     * @param lkm poistettavien lukujen määrä
     * @param suurin suurin poistettava luku
     * @return aika, joka poistamiseen on kulunut millisekunteina
     */
     public static Long poistaLukuja(Puu p, int lkm, int suurin){
        
        Long alkuAika = System.currentTimeMillis();
        Random r = new Random();

        for(int i=0; i < lkm; i++) {
            int luku = r.nextInt(suurin-1)+1;
            p.poista(luku);
        }
        return System.currentTimeMillis() - alkuAika;    
    }     
     
//     private static Solmu[] luoPoistettavatSolmut(int lkm){
//        //ei taida olla hyvä idea 
//     }
//    /**
//     * Alustaa puut, niin että niissä on valmiina tietoalkioita.
//     */
//    private static void alustaPuut(){
//        //ei vielä lopullinen versio
//        for(int i=1; i <= 100; i++){
//           binaari.lisaa(i);
//           punamusta.lisaa(i);
//           viisto.lisaa(i);
//        }  
//        System.out.println("Puissa on aluksi valmiina luvut 1-100.");
//        System.out.println();
//    }
//     
}
