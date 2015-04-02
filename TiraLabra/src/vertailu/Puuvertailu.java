package vertailu;

import java.util.Scanner;
/**
 * Luokan tarkoituksena on vertailla erilaisia puurakenteita ja
 * niiden tehokkuutta lisäys-, poisto- ja hakuoperaatioissa.
 *
 * @author Anu
 */
public class Puuvertailu {
    
   private static Scanner lukija = new Scanner(System.in);
    
   private static Puu binaari = new BinHakupuu();
   private static PunamustaPuu punamusta = new PunamustaPuu();
//    Splaypuu viisto;
//    Treap puukeko;
    
    private static void printtaaInfo(){
        System.out.println("Ohjelma vertailee 4 eri tietorakenteen tehokkuutta.");
        System.out.println("Vertailussa ovat binäärihakupuu, punamusta puu, splay-pyy ja treap.");
        System.out.println("Voit vertailla seuraavia operaatioita: lisäys, poisto, haku.");
        System.out.println();
    }
    
    private static String toimintaValikko(){
        System.out.println("Valitse haluamasi toiminto oikealla numerolla.");
        System.out.println("1 - Vertaile lisäystä");
        System.out.println("2 - Vertaile poistoa");
        System.out.println("3 - Vertaile hakua");
        System.out.println("4 - Lopeta ohjelma");
        
        String valittu = lukija.next();
        valittu.trim();
        return valittu;        
    }
    
    private static void alustaPuut(){
        for(int i=1; i <= 100; i++){
           binaari.lisaa(i);
           punamusta.lisaa(i);
        }  
        System.out.println("Puissa on aluksi valmiina luvut 1-100.");
        System.out.println();
    }

    private static void vertaileLisays(){
        //vasta alustava kokeilu, kantsii ehkä tehdä oma luokka näille 
        
        System.out.println("Lisätään 400 lukua puihin.");
        
        Long binAlkuAika = System.currentTimeMillis();
        for(int i=101; i <= 500; i++) {
             binaari.lisaa(i);
        }
         Long binKulunutAika = System.currentTimeMillis() - binAlkuAika;       
        
         Long pmAlkuAika = System.currentTimeMillis();
         for(int i=101; i <= 500; i++) {
             punamusta.lisaa(i);
         }
          Long pmKulunutAika = System.currentTimeMillis() - pmAlkuAika;        
                
        System.out.println();
        System.out.println("Lukujen lisäykseen meni binäärihakupuussa aikaa " +
                binKulunutAika + " millisekuntia ja punamustassa puussa "+
                pmKulunutAika + " millisekuntia." );
    }
    
    private static void vertailePoisto(){
        System.out.println("Vertaillaan poistoa.");
    }
    
    private static void vertaileHaku(){
        System.out.println("Vertaillaan hakua.");
    }    

    public static void main(String[] args) {
        
        String valinta = "";       
        
        printtaaInfo();
        alustaPuut();        
        
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
                    System.out.println("Hei hei!");
                    break;
           }           
        }while (!valinta.equals("4"));
                   
    }
    
}
