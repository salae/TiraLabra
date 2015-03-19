package vertailu;

/**
 * Luokan tarkoituksena on vertailla erilaisia puurakenteita, ja
 * niiden tehokkuutta lisäys-, poisto- ja hakuoperaatioissa.
 *
 * @author Anu
 */
public class Puuvertailu {
    
        BinHakupuu binaari;
        PunamustaPuu punamusta;
        Splaypuu viisto;
        Treap puukeko;
    
    
    private static void printtaaInfo(){
        System.out.println("Ohjelma vertailee 4 eri tietorakenteen tehokkuutta.");
        System.out.println("Vertailussa ovat binäärihakupuu, punamusta puu, splay-pyy ja treap.");
        System.out.println("Voit vertailla seuraavia operaatioita: lisäys, poisto, haku.");
    }
    

    public static void main(String[] args) {
        
        printtaaInfo();
        
    }
    
}
