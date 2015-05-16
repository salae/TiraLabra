
package vertailu;

/**
 * Punamustan puun solmu.
 * 
 * Perussolmuun lisätään tieto solmun väristä: punainen tai musta.
 * 
 * @author Anu
 */
public class PmSolmu extends Solmu{
    
    private boolean punainen; //punainen on true, musta on false
    
    /**
     * Luo uuden punamustan puun solmun.
     * 
     * @param avain
     * @param onkoPunainen true, jos punainen; false, jos musta
     */
    public PmSolmu(int avain, boolean onkoPunainen){
        super(avain);
        this.punainen = onkoPunainen;
    }

    /**
     * Palauttaa tiedon siitä, onko solmu punainen vai musta
     * 
     * @return true, jos solmu on punainen; false, jos musta
     */
    public boolean onkoPunainen() {
        return punainen;
    }

    /**
     * Asettaa solmulle värin
     * 
     * @param punainen true, jos punainen; false, jos musta
     */
    public void asetaVari(boolean punainen) {
        this.punainen = punainen;
    }
  
    @Override
        public String toString(){
        String vari = (punainen) ? "punainen" : "musta" ;
        return String.valueOf(this.getAvain()) +
                " (" + vari +")";
    }
}
