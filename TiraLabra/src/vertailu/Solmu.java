package vertailu;

/**
 * Puun solmu, jossa tietoalkioina on kokonaislukuja,
 * jotka toimivat samalla solmun avaimina.
 * 
 * @author Anu
 */
public class Solmu implements Comparable<Solmu>{
    
    private int avain;
    private Solmu vasenLapsi;
    private Solmu oikeaLapsi;
    private Solmu vanhempi;
    
    /**
     * Luo uuden solmun, jonka avain annetaan parametrinä.
     * 
     * @param avain solmun avain 
     */
    public Solmu(int avain) {
        this.avain = avain;
        this.vasenLapsi = this.oikeaLapsi = this.vanhempi = null;
    }

    /**
     * Palauttaa solmun avaimen.
     * 
     * @return solmun avain
     */
    public int getAvain() {
        return this.avain;
    }

    /**
     * Asettaa solmuun avaimen.
     * 
     * @param avain solmun uusi avain
     */
    public void setAvain(int avain) {
        this.avain = avain;
    }

    /**
     * Palauttaa solmun vasemman lapsen.
     * 
     * @return solmun vasen lapsi
     */
    public Solmu getVasenLapsi() {
        return this.vasenLapsi;
    }

    /**
     * Asettaa solmulle vasemman lapsen.
     * 
     * @param vasenLapsi solmun uusi vasen lapsi
     */
    public void setVasenLapsi(Solmu vasenLapsi) {
        this.vasenLapsi = vasenLapsi;
    }

    /**
     * Palauttaa solmun oikean lapsen.
     * 
     * @return solmun oikea lapsi
     */
    public Solmu getOikeaLapsi() {
        return this.oikeaLapsi;
    }

    /**
     * Asettaa solmulle oikean lapsen.
     * 
     * @param oikeaLapsi solmun uusi oikea lapsi
     */
    public void setOikeaLapsi(Solmu oikeaLapsi) {
        this.oikeaLapsi = oikeaLapsi;
    }

    /**
     * Palauttaa solmun vanhemman.
     * 
     * @return solmun vanhempi
     */
    public Solmu getVanhempi() {
        return this.vanhempi;
    }

    /**
     * Asettaa solmulle vanhemman.
     * 
     * @param vanhempi solmun uusi vanhempi
     */
    public void setVanhempi(Solmu vanhempi) {
        this.vanhempi = vanhempi;
    }
    
    /**
     * Palauttaa solmun sisällön tekstimuodossa.
     * 
     * @return solmun sisältö merkkijonona
     */
    @Override
    public String toString(){
        return String.valueOf(this.avain);
    }

    /**
     * Vertailee solmuja avainten arvojen perusteella.
     * 
     * @param vertailtava solmu, johon vertaillaan
     * @return 0, jos solmujen avaimet ovat yhtä suuria; 
     * negatiivinen luku, jos vertailtava on suurempi; 
     * posittivnen luku, jos vertailtava on pienempi 
     */
    @Override
     public int compareTo(Solmu vertailtava) {
       return this.getAvain() - vertailtava.getAvain();
    }
    
}
