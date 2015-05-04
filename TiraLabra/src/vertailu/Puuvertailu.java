package vertailu;

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
//        System.out.println("4 - Valmiit testit");
        System.out.println("0 - Lopeta ohjelma");
        
        String valittu = lukija.next();
        return valittu.trim();      
    }

    /**
     * Päämetodi, josta ohjelma käynnistetään.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        String valinta = ""; 
        int[] lukumaarat = {20000,50000,100000};
        int[] lukumaarat2 = {5,10};
        Vertailu v = new Vertailu();
        
        printtaaInfo();       
        
        do {
           valinta = toimintaValikko();
           switch (valinta) {
                case "1":
                    v.vertaileLisays(lukumaarat,1000 ,10);
                    break;
                case "2":
                    v.vertailePoisto(lukumaarat2,1000 ,3);
                    break;
                case "3":
                    v.vertaileHaku(lukumaarat,10000,10);
                    break;
//                case "4":
//                    valmiitTestit();
//                    break;                    
                case "0":
                    System.out.println("Hei hei!");
                    break;
           }           
        }while (!valinta.equals("0"));
                   
    }
    
}
