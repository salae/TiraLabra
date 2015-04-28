
package vertailu;

import java.util.Random;

/**
 * Luokka sisältää erilaisia vertailuun käytettäviä metodeja.
 * 
 * @author Anu
 */
public class Vertailu {
   private BinHakupuu binaari;
   private PunamustaPuu punamusta;
   private Splaypuu viisto;
   private Treap puukeko;
   private Puu[] puut;
   
   public Vertailu(){       
       this.binaari = new BinHakupuu();
       this.punamusta = new PunamustaPuu();
       this.viisto = new Splaypuu();
       this.puukeko = new Treap();
       this.puut = new Puu[4];
       this.puut[0]= this.binaari;
       this.puut[1] = this.punamusta;
       this.puut[2] = this.viisto;
       this.puut[3] = this.puukeko;
   }

    public BinHakupuu getBinaari() {
        return binaari;
    }

    public void setBinaari(BinHakupuu binaari) {
        this.binaari = binaari;
    }

    public PunamustaPuu getPunamusta() {
        return punamusta;
    }

    public void setPunamusta(PunamustaPuu punamusta) {
        this.punamusta = punamusta;
    }

    public Splaypuu getViisto() {
        return viisto;
    }

    public void setViisto(Splaypuu viisto) {
        this.viisto = viisto;
    }

    public Treap getPuukeko() {
        return puukeko;
    }

    public void setPuukeko(Treap puukeko) {
        this.puukeko = puukeko;
    }

    public Puu[] getPuut() {
        return puut;
    }

    public void setPuut(Puu[] puut) {
        this.puut = puut;
    }
   
   
   /**
    * Vertailee tietoalkioiden lisäykseen kuluvaa aikaa.
    * 
    * Tulostaa vertailun tulokset standardiin tulostusvirtaan.
    * 
    * @param maarat lisättävien lukujen määrät taulukossa
    * @param maxi suurin lisättä luku
    * @param kertaa kuinka monta kertaa lisäys toistetaan
    */
    public void vertaileLisays(int[] maarat , int maxi, int kertaa){  
        Long[] ajat = new Long[4];
        
        System.out.println("Vertaillaan lisäystä.");
        
        for(int i = 0; i < maarat.length; i++){
            System.out.println("Lisätään " + maarat[i] +" satunnaista lukua väliltä 1-"+maxi+" puihin.");
            System.out.println();        
            for(int j = 0; j< puut.length; j++){
                ajat[j] = laskeLisaystenKeskiarvo(puut[j],maarat[i],maxi,kertaa);
            }
        System.out.println();
        System.out.println("Lukujen lisäykseen meni aikaa binäärihakupuussa keskimäärin " + ajat[0] +",");
        System.out.println("punamustassa puussa "+ ajat[1] + ",");
        System.out.println("splaypuussa "+ ajat[2] + " ja treapissa "+ ajat[3] + " millisekuntia." );
        
        System.out.println(); 
        }
        
      System.out.println();             

    }
    /**
    * Vertailee tietoalkioiden poistamiseen kuluvaa aikaa.
    * 
    * Tulostaa vertailun tulokset standardiin tulostusvirtaan.
    * 
    * @param maarat poistettavien lukujen määrät taulukossa
    * @param maxi suurin poistettava luku
    * @param kertaa kuinka monta kertaa poistot toistetaan
    */
    public void vertailePoisto(int[] maarat , int maxi, int kertaa){  
        Long[] ajat = new Long[4];
        puut = new Puu[3];
        this.puut[0]= this.binaari;
        this.puut[1] = this.viisto;
       this.puut[2] = this.puukeko;

        
        System.out.println("Vertaillaan poistoa.");
//        alustaPuut(100000,10000);
        alustaPuut(100,50);
        System.out.println("Koska luvut pitää ensin hakea, käytännössä on kyseessä haku + poisto.");
        
        for(int i = 0; i < maarat.length; i++){
            System.out.println("Poistetaan " + maarat[i] +" satunnaista lukua väliltä 1-"+maxi+" puista.");
            System.out.println();        
            for(int j = 0; j< puut.length; j++){
                ajat[j] = laskePoistojenKeskiarvo(puut[j],maarat[i],maxi,kertaa);
            }
        System.out.println();
        System.out.println("Lukujen poistoon meni aikaa binäärihakupuussa keskimäärin " + ajat[0] +",");
        System.out.println("punamustassa puussa "+ ajat[1] + ",");
        System.out.println("splaypuussa "+ ajat[2] + " ja treapissa "+ ajat[3] + " millisekuntia." );
        
        System.out.println(); 
        }
        
      System.out.println();             

    }      
//    public void vertailePoisto(){
//        System.out.println("Vertaillaan poistoa.");
//        System.out.println("Koska luvut pitää ensin hakea, käytännössä on kyseessä haku + poisto.");
//        alustaPuut(10000,1000);
//        System.out.println("Poistetaan 10000 satunnaista lukua väliltä 1-1000 puista.");
//        
//        Long binLisAika1 = Toimintoja.laskePoistojenKeskiarvo(binaari, 10000,1000,5);   
////        Long pmLisAika1 = Toimintoja.laskePoistojenKeskiarvo(punamusta,10000,1000,5);
//        Long vLisAika1 = Toimintoja.laskePoistojenKeskiarvo(viisto,10000,1000,5);  
//        Long tLisAika1 = Toimintoja.laskePoistojenKeskiarvo(puukeko,10000,1000,5); 
//        
//        System.out.println();
//        System.out.println("Lukujen hakuun meni aikaa binäärihakupuussa keskimäärin " + binLisAika1 +",");
////        System.out.println("punamustassa puussa "+ pmLisAika1 + ",");
//        System.out.println("splaypuussa "+ vLisAika1 + " ja treapissa "+ tLisAika1 + " millisekuntia." );
//        
//        System.out.println();        
//        
//        System.out.println("Poistetaan 50000 satunnaista lukua väliltä 1-1000 puista.");
//        
//        binLisAika1 = Toimintoja.laskePoistojenKeskiarvo(binaari, 50000,1000,5);   
////        pmLisAika1 = Toimintoja.laskePoistojenKeskiarvo(punamusta,50000,1000,5);
//        vLisAika1 = Toimintoja.laskePoistojenKeskiarvo(viisto,50000,1000,5);  
//        tLisAika1 = Toimintoja.laskePoistojenKeskiarvo(puukeko,50000,1000,5); 
//        
//        System.out.println();
//        System.out.println("Lukujen poistoon meni aikaa binäärihakupuussa keskimäärin " + binLisAika1 +",");
////        System.out.println("punamustassa puussa "+ pmLisAika1 + ",");
//        System.out.println("splaypuussa "+ vLisAika1 + " ja treapissa "+ tLisAika1 + " millisekuntia." );
//        
//        System.out.println();      
//        
//        System.out.println("Haetaan  100 000 satunnaista lukua väliltä 1-1000 puista.");
//        
//        binLisAika1 = Toimintoja.laskePoistojenKeskiarvo(binaari, 100000,1000,5);   
////        pmLisAika1 = Toimintoja.laskePoistojenKeskiarvo(punamusta,100000,1000,5);
//        vLisAika1 = Toimintoja.laskePoistojenKeskiarvo(viisto,100000,1000,5);  
//        tLisAika1 = Toimintoja.laskePoistojenKeskiarvo(puukeko,100000,1000,5); 
//        
//        System.out.println();
//        System.out.println("Lukujen poistoon meni aikaa binäärihakupuussa keskimäärin " + binLisAika1 +",");
////        System.out.println("punamustassa puussa "+ pmLisAika1 + ",");
//        System.out.println("splaypuussa "+ vLisAika1 + " ja treapissa "+ tLisAika1 + " millisekuntia." );
//        
//        System.out.println();     
//    }
    /**
    * Vertailee tietoalkioiden hakemiseen kuluvaa aikaa.
    * 
    * Tulostaa vertailun tulokset standardiin tulostusvirtaan.
    * 
    * @param maarat haettavien lukujen määrät taulukossa
    * @param maxi suurin haettava luku
    * @param kertaa kuinka monta kertaa haut toistetaan
    */
    public void vertaileHaku(int[] maarat , int maxi, int kertaa){  
        Long[] ajat = new Long[4];
        
        System.out.println("Vertaillaan hakua.");
        alustaPuut(500000,1000);
        
        for(int i = 0; i < maarat.length; i++){
            System.out.println("Haetaan " + maarat[i] +" satunnaista lukua väliltä 1-"+maxi+" puista.");
            System.out.println();        
            for(int j = 0; j< puut.length; j++){
                ajat[j] = laskeHakujenKeskiarvo(puut[j],maarat[i],maxi,kertaa);
            }
        System.out.println();
        System.out.println("Lukujen hakuun meni aikaa binäärihakupuussa keskimäärin " + ajat[0] +",");
        System.out.println("punamustassa puussa "+ ajat[1] + ",");
        System.out.println("splaypuussa "+ ajat[2] + " ja treapissa "+ ajat[3] + " millisekuntia." );
        
        System.out.println(); 
        }
        
      System.out.println();             

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
    public Long teeLisays(Puu p, int lkm, int suurin){
        
        Long alkuAika = System.currentTimeMillis();
        Random r = new Random();

        for(int i=0; i < lkm; i++) {
            int luku = r.nextInt(suurin)+1;
             p.lisaa(luku);
        }
        return System.currentTimeMillis() - alkuAika;    
    }
     /**
      * Toistaa halutun määrän teeLisays-metodia ja laskee tulosten keski-arvon.
      * 
      * @param p puu, johon lisäykset tehdään
      * @param lkm lisättävien lukujen määrä
      * @param suurin suurin lisättävä luku
      * @param kierros haluttu määrä metodin toistoja
      * @return lisäyksiin kuluneiden aikojen keskiarvo
      */
    public Long laskeLisaystenKeskiarvo(Puu p, int lkm, int suurin, int kierros){
        Long ka = new Long(0);
        System.out.print(p.getClass().getSimpleName()+ "\t");
        if(p.getClass().getSimpleName().length() < 8){System.out.print("\t");}
        for(int i = 0; i < kierros; i++){
            Long aika = teeLisays(p,lkm,suurin);
            System.out.print(aika + "\t");
            ka += aika;
            p.tyhjennaPuu(((BinHakupuu)p).getJuuri());            
        } 
        System.out.println();
        return ka/kierros;
    }
    
    /**
     * Hakee puusta halutun määrän satunnaisia lukuja.
     * 
     * @param p puu, josta haut tehdään
     * @param lkm haettavien lukujen määrä
     * @param suurin suurin haettava luku
     * @return aika, joka hakemiseen on kulunut millisekunteina
     */
     public Long haeLukuja(Puu p, int lkm, int suurin){
        
        Long alkuAika = System.currentTimeMillis();
        Random r = new Random();

        for(int i=0; i < lkm; i++) {
            int luku = r.nextInt(suurin-1)+1;
             p.hae(luku);
        }
        return System.currentTimeMillis() - alkuAika;    
    } 
     
      /**
      * Toistaa halutun määrän haeLukuja-metodia ja laskee tulosten keski-arvon.
      * 
      * @param p puu, josta haut tehdään
      * @param lkm haettavien lukujen määrä
      * @param suurin suurin haettava luku
      * @param kierros haluttu määrä metodin toistoja
      * @return hakuihin kuluneiden aikojen keskiarvo
      */
    public Long laskeHakujenKeskiarvo(Puu p, int lkm, int suurin, int kierros){
        Long ka = new Long(0);
        System.out.print(p.getClass().getSimpleName()+ "\t");
        if(p.getClass().getSimpleName().length() < 8){System.out.print("\t");}
        for(int i = 0; i < kierros; i++){
            Long aika = haeLukuja(p,lkm,suurin);
            System.out.print(aika + "\t");
            ka += aika;            
        } 
        System.out.println();
        return ka/kierros;
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
     public Long poistaLukuja(Puu p, int lkm, int suurin){
        
        Long alkuAika = System.currentTimeMillis();
        Random r = new Random();

        for(int i=0; i < lkm; i++) {
            int luku = r.nextInt(suurin-1)+1;
            p.poista(luku);
        }
        return System.currentTimeMillis() - alkuAika;    
    }     

      /**
      * Toistaa halutun määrän poistaLukuja-metodia ja laskee tulosten keski-arvon.
      * 
      * @param p puu, josta poistot tehdään
      * @param lkm poistettavien lukujen määrä
      * @param suurin suurin poistettava luku
      * @param kierros haluttu määrä metodin toistoja
      * @return poistoihin kuluneiden aikojen keskiarvo
      */
    public Long laskePoistojenKeskiarvo(Puu p, int lkm, int suurin, int kierros){
        Long ka = new Long(0);
        System.out.print(p.getClass().getSimpleName()+ "\t");
        if(p.getClass().getSimpleName().length() < 8){System.out.print("\t");}
        for(int i = 0; i < kierros; i++){
            Long aika = poistaLukuja(p,lkm,suurin);
            System.out.print(aika + "\t");
            ka += aika;            
        } 
        System.out.println();
        return ka/kierros;
    }      
    
     /**
     * Laittaa puihin valmiiksi tietoalkioita.
     * 
     */
    public void alustaPuut(int lkm, int suurin){
         System.out.println("Puissa on valmiina " + lkm + " satunnaista lukua väliltä 1-" + suurin +".");
         
         for(int i = 0; i < this.puut.length; i++){
             this.teeLisays(puut[i], lkm, suurin);
         }
       
//        teeLisays(binaari, lkm, suurin);
//        teeLisays(punamusta, lkm, suurin);
//        teeLisays(viisto, lkm, suurin);
//        teeLisays(puukeko, lkm, suurin);        
    } 
}
