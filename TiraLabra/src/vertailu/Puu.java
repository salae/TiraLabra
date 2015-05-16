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
     * Jos avainta ei löydy puusta, ei tehdä mitään.
     * 
     * @param avain poistettava avain
     */
    public void poista(int avain);
    
    /**
     * Tyhjentää annetusta solmusta alkavan alipuun.
     * 
     * Poistaa kaikki puun solmut.
     * 
     * @param s juuri, josta alkava alipuu tyhjennetään
     */
    public void tyhjennaPuu(Solmu s);   
    
    /**
     * Tulostaa annetusta solmusta alkavan alipuun.
     * 
     * Jos halutaan tulostaa koko puu, annetaan parametrina puun juuri.
     * 
     * @param s juuri, josta alkava alipuu tulostetaan
     */
    public void tulostaPuu(Solmu s);
    
     /**
     * Palauttaa solmun, jolla on arvoltaan pienin avain.
     * 
     * Pienimmän arvon etsintä koskee alipuuta, jonka juuri annetaan parametrinä.
     * Pienimpiä arvoja voi olla useita, joista yksi palautetaan. Jos puu on
     * tyhjä, palautetaan null.
     * 
     * @param s sen puun juuri, josta pienintä arvoa haetaan
     * @return pienimmän avaimen omaava solmu
     */   
    public Solmu haeMin(Solmu s);
 
    /**
     * Palauttaa solmun, jolla on arvoltaan suurin avain.
     * 
     * Suurimman arvon etsintä koskee alipuuta, jonka juuri annetaan parametrinä.
     * Suurimpia arvoja voi olla useita, joista yksi palautetaan. Jos puu on
     * tyhjä, palautetaan null.
     * 
     * @param s sen puun juuri, josta suurinta arvoa haetaan
     * @return suurimman avaimen omaava solmu
     */   
    public Solmu haeMax(Solmu s);
    
}
