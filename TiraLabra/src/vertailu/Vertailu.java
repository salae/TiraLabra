package vertailu;

import java.util.Random;

/**
 * Luokan olioiden avulla voi vertailla neljän eri hakupuun tehokkuuta
 * lisäys-, haku-, ja poisto-operaatioissa.
 * 
 * @author Anu
 */
public class Vertailu {
   private Puu[] puut;
   
   /**
    * Luo uuden vertailu-olion.
    */
   public Vertailu(){       
       this.puut = new Puu[4];
       this.puut[0]= new BinHakupuu();
       this.puut[1] = new PunamustaPuu();
       this.puut[2] = new Splaypuu();
       this.puut[3] = new Treap();
   }

   /**
    * Palauttaa vertailun puut.
    * 
    * @return puut
    */
    public Puu[] getPuut() {
        return puut;
    }
    /**
     * Asettaa vertailuun uudet puut.
     * 
     * @param puut vertailtavat puut
     */
    public void setPuut(Puu[] puut) {
        this.puut = puut;
    }
   
   /**
    * Vertailee tietoalkioiden lisäykseen kuluvaa aikaa.
    * 
    * Tulostaa vertailun tulokset standardiin tulostusvirtaan.
    * 
    * @param maarat lisättävien lukujen määrät taulukossa
    * @param maxi suurin mahdollinen lisättävä luku
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
        System.out.println("punamustassa puussa "+ ajat[1] + ", splaypuussa " + ajat[2]);
        System.out.println("ja treapissa "+ ajat[3] + " millisekuntia." );        
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
    * @param maxi suurin mahdollinen poistettava luku
    * @param kertaa kuinka monta kertaa poistot toistetaan
    * @param aLkm solmujen määrä alussa
    */
    public void vertailePoisto(int[] maarat , int maxi, int kertaa, int aLkm){ 
        Long[] ajat = new Long[4];
        
        System.out.println("Vertaillaan poistoa.");
        System.out.println("Puissa on valmiina " + aLkm + " satunnaista lukua väliltä 1-" + maxi +".");        
        alustaPuut(aLkm,maxi);
        System.out.println("Koska luvut pitää ensin hakea, käytännössä on kyseessä haku + poisto.");        
        for(int i = 0; i < maarat.length; i++){
            System.out.println("Poistetaan " + maarat[i] +" satunnaista lukua väliltä 1-"+maxi+" puista.");
            System.out.println();        
            for(int j = 0; j< puut.length; j++){
                ajat[j] = laskePoistojenKeskiarvo(puut[j],maarat[i],maxi,kertaa,aLkm);
            }
        System.out.println();
        System.out.println("Lukujen poistoon meni aikaa binäärihakupuussa keskimäärin " + ajat[0] +",");
        System.out.println("punamustassa puussa "+ ajat[1] + ", splaypuussa "+ ajat[2]);
        System.out.println("ja treapissa "+ ajat[3] + " millisekuntia." );        
        System.out.println(); 
        }        
      System.out.println();    
    }      

   /**
    * Vertailee tietoalkioiden hakemiseen kuluvaa aikaa.
    * 
    * Tulostaa vertailun tulokset standardiin tulostusvirtaan.
    * 
    * @param maarat haettavien lukujen määrät taulukossa
    * @param maxi suurin mahdollinen haettava luku
    * @param kertaa kuinka monta kertaa haut toistetaan
    * @param aLkm solmujen määrä alussa
    * 
    */
    public void vertaileHaku(int[] maarat , int maxi, int kertaa, int aLkm){ 
        Long[] ajat = new Long[4];
        
        System.out.println("Vertaillaan hakua."); 
        System.out.println("Puissa on valmiina " + aLkm + " satunnaista lukua väliltä 1-" + maxi +".");
        alustaPuut(aLkm,maxi);        
        for(int i = 0; i < maarat.length; i++){
            System.out.println("Haetaan " + maarat[i] +" satunnaista lukua väliltä 1-"+maxi+" puista.");
            System.out.println();        
            for(int j = 0; j< puut.length; j++){
                ajat[j] = laskeHakujenKeskiarvo(puut[j],maarat[i],maxi,kertaa);
            }
        System.out.println();
        System.out.println("Lukujen hakuun meni aikaa binäärihakupuussa keskimäärin " + ajat[0] +",");
        System.out.println("punamustassa puussa "+ ajat[1] + ", splaypuussa "+ ajat[2]);
        System.out.println("ja treapissa "+ ajat[3] + " millisekuntia." );        
        System.out.println(); 
        }
        
        for (Puu puut1 : this.puut) {
           puut1.tyhjennaPuu(((BinHakupuu) puut1).getJuuri());
        } 
    }   
    
    /**
     * Lisää puuhun halutun määrän satunnaisia kokonaislukuja 
     * väliltä 1 - määritelty suurin luku.
     * 
     * @param p puu, johon lisäykset tehdään
     * @param lkm lisättävien lukujen määrä
     * @param suurin suurin mahdollinen lisättävä luku
     * 
     * @return aika, joka lisäyksiin on kulunut millisekunteina
     */
    private Long teeLisays(Puu p, int lkm, int suurin){
        
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
      * @param suurin suurin mahdollinen lisättävä luku
      * @param kierros haluttu määrä metodin toistoja
      * 
      * @return lisäyksiin kuluneiden aikojen keskiarvo
      */
    private Long laskeLisaystenKeskiarvo(Puu p, int lkm, int suurin, int kierros){
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
     * @param suurin suurin mahdollinen haettava luku
     * 
     * @return aika, joka hakemiseen on kulunut millisekunteina
     */
     private Long haeLukuja(Puu p, int lkm, int suurin){
        Long alkuAika = System.currentTimeMillis();
        Random r = new Random();

        for(int i=0; i < lkm; i++) {
            int luku = r.nextInt(suurin)+1;
            p.hae(luku);
        }
        return System.currentTimeMillis() - alkuAika;    
    } 
     
     /**
      * Toistaa halutun määrän haeLukuja-metodia ja laskee tulosten keski-arvon.
      * 
      * @param p puu, josta haut tehdään
      * @param lkm haettavien lukujen määrä
      * @param suurin suurin mahdollinen haettava luku
      * @param kierros haluttu määrä metodin toistoja
      * 
      * @return hakuihin kuluneiden aikojen keskiarvo
      */
    private Long laskeHakujenKeskiarvo(Puu p, int lkm, int suurin, int kierros){
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
     * @param suurin suurin mahdollinen poistettava luku
     * 
     * @return aika, joka poistamiseen on kulunut millisekunteina
     */
     private Long poistaLukuja(Puu p, int lkm, int suurin){        
        Long alkuAika = System.currentTimeMillis();
        Random r = new Random();

        for(int i=0; i < lkm; i++) {
            int luku = r.nextInt(suurin)+1;
            p.poista(luku);
        }
        return System.currentTimeMillis() - alkuAika;    
    }     

     /**
      * Toistaa halutun määrän poistaLukuja-metodia ja laskee tulosten keski-arvon.
      * 
      * @param p puu, josta poistot tehdään
      * @param lkm poistettavien lukujen määrä
      * @param suurin suurin mahdollinen poistettava luku
      * @param kierros haluttu määrä metodin toistoja
      * @param aLkm solmujen määrä alussa
      * 
      * @return poistoihin kuluneiden aikojen keskiarvo
      */
    private Long laskePoistojenKeskiarvo(Puu p, int lkm, int suurin, int kierros, int aLkm){
        Long ka = new Long(0);
        System.out.print(p.getClass().getSimpleName()+ "\t");
        if(p.getClass().getSimpleName().length() < 8){System.out.print("\t");}
        for(int i = 0; i < kierros; i++){
            Long aika = poistaLukuja(p,lkm,suurin);
            System.out.print(aika + "\t");
            ka += aika;  
            p.tyhjennaPuu(((BinHakupuu)p).getJuuri()); 
            this.teeLisays(p, aLkm, suurin);
        } 
        System.out.println();
        return ka/kierros;
    }      
    
    /**
     * Laittaa puihin valmiiksi tietoalkioita.
     * 
     * @param lkm lisättävien solmujen määrä
     * @param suurin suurin mahdollinen avaimen arvo
     */
    private void alustaPuut(int lkm, int suurin){         
       for (Puu puut1 : this.puut) {
           this.teeLisays(puut1, lkm, suurin);
       }       
    } 
}
