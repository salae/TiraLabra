package vertailu;

import java.util.Scanner;
/**
 * Luokka sisältää päämetodin, josta ohjelma käynnistetään 
 * sekä tekstipohjaisen käyttöliittymän.
 *
 * Ohjelman tarkoituksena on vertailla erilaisia puurakenteita ja
 * niiden tehokkuutta lisäys-, poisto- ja hakuoperaatioissa.
 * 
 * @author Anu
 */
public class Main {
    
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
        int[] lukumaarat = {200,1000,2000};
        int[] lukumaarat2 = {5000 ,10000};
        int[] lukumaarat3 = {200000};
        Vertailu v = new Vertailu();
        
        printtaaInfo();    
        
        
        
        do {
           valinta = toimintaValikko();
           switch (valinta) {
                case "1":
                    v.vertaileLisays(lukumaarat3,1000 ,2);
                    break;
                case "2":
                    v.vertailePoisto(lukumaarat2,10000,5,100000);
                    break;
                case "3":
                    v.vertaileHaku(lukumaarat3,10000,2,100000);
                    break;                   
                case "0":
                    System.out.println("Hei hei!");
                    break;
           }           
        }while (!valinta.equals("0"));                   
    }    
}
