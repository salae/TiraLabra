
package vertailu;

import java.util.Random;

/**
 * Treapin solmu.
 * 
 * Lisää perussolmuun satunnaisen prioriteettiluvun.
 * 
 * @author Anu
 */
public class TreapSolmu extends Solmu{
    
    private int prioriteetti;

    /**
     * Luo uuden Treapin solmun
     * 
     * @param avain 
     */
    public TreapSolmu(int avain) {
        super(avain);
        this.prioriteetti = new Random().nextInt();
    }
    /**
     * Palauttaa solmun prioriteetin
     * 
     * @return prioriteetti
     */
    public int getPrioriteetti() {
        return this.prioriteetti;
    }
    /**
     * Asettaa solmulle prioriteetin
     * 
     * @param prioriteetti 
     */
    public void setPrioriteetti(int prioriteetti) {
        this.prioriteetti = prioriteetti;
    }

    @Override
    public String toString() {

        return String.valueOf(this.getAvain()) +
                " (" + this.getPrioriteetti() +")";
    }
    
    
}
