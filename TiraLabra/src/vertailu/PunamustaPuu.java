package vertailu;

import java.util.TreeSet;

/**
 * Punamusta puu on tasapainotettu binäärinen hakupuu, jonka solmuissa on
 * tieto siitä, onko solmu punainen vai musta.
 * 
 * @author Anu
 */
public class PunamustaPuu implements Puu{
    
    // Toteutetaan ensin Javan TreeSet luokan avulla
    private TreeSet<Solmu>  pmPuu; 

    /**
     * Luo tyhjän punamustan puun
     */
    public PunamustaPuu() {
        this.pmPuu = new TreeSet<Solmu>();
    }

    @Override
    public Solmu hae(int avain) {
        //palaluttaa viitteen "irralliseen" solmuun, mutta riittää tähän
        Solmu haettu = new Solmu(avain);
        if(this.pmPuu.contains(haettu)){
            return haettu;
        } else {
            return null;
        }        
    }

    @Override
    public void lisaa(int avain) {
        this.pmPuu.add(new Solmu(avain));
    }

    @Override
    public void poista(int avain) {
        this.pmPuu.remove(new Solmu(avain));
    }
    
    /**
     * Tulostaa puun alkiot
     * 
     * @return puun alkiot
     */
    public String tulostaPuu(){
        String puuTuloste = "";
        for (Solmu s : this.pmPuu)
            System.out.println(s);        
        return puuTuloste;
    }
    
}

