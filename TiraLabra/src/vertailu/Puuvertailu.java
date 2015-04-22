package vertailu;

import java.util.Random;
import java.util.Scanner;
/**
 * Luokan tarkoituksena on vertailla erilaisia puurakenteita ja
 * niiden tehokkuutta lisäys-, poisto- ja hakuoperaatioissa.
 * 
 * Sisältää päämetodin, josta ohjelma käynnistetään.
 *
 * @author Anu
 */
public class Puuvertailu {
    
   private static Scanner lukija = new Scanner(System.in);
    
   private static Puu binaari = new BinHakupuu();
   private static PunamustaPuu punamusta = new PunamustaPuu();
   private static Splaypuu viisto = new Splaypuu();
//    Treap puukeko;
    
   /**
    * Tulostaa yleiskuvauksen ohjelmasta.
    */ 
   private static void printtaaInfo(){
        System.out.println("Ohjelma vertailee 4 eri tietorakenteen tehokkuutta.");
        System.out.println("Vertailussa ovat binäärihakupuu, punamusta puu, splay-pyy ja treap.");
        System.out.println("Voit vertailla seuraavia operaatioita: lisäys, poisto, haku.");
        System.out.println();
    }
    /**
     * Tulostaa ohjelman käyttövalikon.
     * 
     * @return valittu toiminto
     */
    private static String toimintaValikko(){
        System.out.println("Valitse haluamasi toiminto oikealla numerolla.");
        System.out.println("1 - Vertaile lisäystä");
        System.out.println("2 - Vertaile poistoa");
        System.out.println("3 - Vertaile hakua");
        System.out.println("4 - Valmiit testit");
        System.out.println("0 - Lopeta ohjelma");
        
        String valittu = lukija.next();
        valittu.trim();
        return valittu;        
    }
    /**
     * Alustaa puut, niin että niissä on valmiina tietoalkioita.
     */
    private static void alustaPuut(){
        //ei vielä lopullinen versio
        for(int i=1; i <= 100; i++){
           binaari.lisaa(i);
           punamusta.lisaa(i);
           viisto.lisaa(i);
        }  
        System.out.println("Puissa on aluksi valmiina luvut 1-100.");
        System.out.println();
    }

    //vasta alustava kokeilu, kantsii ehkä tehdä oma luokka näille vertailuille
    private static void vertaileLisays(){        
        
        System.out.println("Vertaillaan lisäystä.");

//////        Long binKulunutAika = teeLisays(binaari,100000,100);   
//////        Long pmKulunutAika = teeLisays(punamusta,100000,100);
//////        Long vKulunutAika = teeLisays(viisto,100000,100);
////                
//////        System.out.println();
//////        System.out.println("Lukujen lisäykseen meni binäärihakupuussa aikaa " +
//////                binKulunutAika + " millisekuntia ja punamustassa puussa "+
//////                pmKulunutAika + " millisekuntia ja splaypuussa "+               
//////                vKulunutAika + " millisekuntia." );
    }
    /**
     * Lisää puuhun halutun määrän satunnaisia kokonaislukuja 
     * väliltä 1 - määritelty suurin luku.
     * 
     * @param p puu, johon lisäykset tehdään
     * @param lkm lisättävien lukujen määrä
     * @param suurin suurin lisättävä luku
     * @return aika, joka lisäyksiin on kulunut millisekunteina
     */
    private static Long teeLisays(Puu p, int lkm, int suurin){
        
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
     private static Long haeLukuja(Puu p, int lkm, int suurin){
        
        Long alkuAika = System.currentTimeMillis();
        Random r = new Random();

        for(int i=0; i < lkm; i++) {
            int luku = r.nextInt(suurin-1)+1;
             p.hae(luku);
        }
        return System.currentTimeMillis() - alkuAika;    
    }   
    
    //tekemättä
    private static void vertailePoisto(){
        System.out.println("Vertaillaan poistoa.");
    }
    //tekemättä
    private static void vertaileHaku(){
        System.out.println("Vertaillaan hakua.");
    }    
    
    private static void valmiitTestit() {
        
        System.out.println("Lisätään 10 000 satunnaista lukua väliltä 1-100 puihin.");
        
        Long binLisAika1 = teeLisays(binaari,10000,100);   
        Long pmLisAika1 = teeLisays(punamusta,10000,100);
        Long vLisAika1 = teeLisays(viisto,10000,100);  
//        Long tLisAika1 = teeLisays(puukeko,10000,100); 
        
        System.out.println();
        System.out.println("Lukujen lisäykseen meni binäärihakupuussa aikaa " +
        binLisAika1 + " millisekuntia ja punamustassa puussa "+
        pmLisAika1 + " millisekuntia ja splaypuussa "+               
        vLisAika1 + " millisekuntia." );   
        
        System.out.println();
        
         System.out.println("haetaan 1000 satunnaista lukua väliltä 1-100 puihin.");
        
        binLisAika1 = haeLukuja(binaari,1000,100);   
        pmLisAika1 = haeLukuja(punamusta,1000,100);
        vLisAika1 = haeLukuja(viisto,1000,100);  
//        tLisAika1 = teeLisays(puukeko,10000,100); 
        
        System.out.println();
        System.out.println("Lukujen hakemiseen meni binäärihakupuussa aikaa " +
        binLisAika1 + " millisekuntia ja punamustassa puussa "+
        pmLisAika1 + " millisekuntia ja splaypuussa "+               
        vLisAika1 + " millisekuntia." );        
        
//        Long binLisAika2 = teeLisays(binaari,50000,100);   
//        Long pmLisAika2 = teeLisays(punamusta,50000,100);
//        Long vLisAika2 = teeLisays(viisto,50000,100);
////        Long tLisAika2= teeLisays(puukeko,50000,100); 
//        
//        Long binLisAika3= teeLisays(binaari,100000,100);   
//        Long pmLisAika3 = teeLisays(punamusta,100000,100);
//        Long vLisAika3 = teeLisays(viisto,100000,100);
////        Long tLisAika3 = teeLisays(puukeko,100000,100); 
        
    }    
    /**
     * Päämetodi, josta ohjelma käynnistetään.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        String valinta = "";       
        
        printtaaInfo();
//        alustaPuut();        
        
        do {
           valinta = toimintaValikko();
           switch (valinta) {
                case "1":
                    vertaileLisays();
                    break;
                case "2":
                    vertailePoisto();
                    break;
                case "3":
                    vertaileHaku();
                    break;
                case "4":
                    valmiitTestit();
                    break;                    
                case "0":
                    System.out.println("Hei hei!");
                    break;
           }           
        }while (!valinta.equals("0"));
                   
    }


    
}
