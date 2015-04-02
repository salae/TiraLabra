package vertailu;

/**
 * Määrittelee kaikille puille yhteiset metodit.
 * 
 * @author Anu
 */
public interface Puu {
    
    /**
     * Hakee puusta etsittyä avainta.
     * 
     * @param avain etsittävä avain
     * @return Solmu, josta avain löytyy, muuten palauttaa null
     */
    public Solmu hae(int avain);
    
    /**
     * Lisää puuhun uuden avaimen.
     * 
     * @param avain lisättävä avain
     */
    public void lisaa(int avain);
    
    /**
     * Poistaa puusta halutun avaimen.
     * 
     * @param avain poistettava avain
     */
    public void poista(int avain);
    
//  Mietin vielä tarvitaanko seuraavia
//    public String tulostaPuu();
//    public int haeMin();
//    public int haeMax();
    
}