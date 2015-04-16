package vertailu;

/**
 * Treap. Puun ja keon yhdistelmä, joka käyttää satunnaisuutta hyväkseen.
 * 
 * @author Anu
 */
public class Treap extends BinHakupuu implements Puu{
    private Solmu juuri;

    /**
     * Luo tyhjän Treap-tietorakenteen.
     * 
     */
    public Treap() {
        
    }

    @Override
    public void poista(int avain) {
        super.poista(avain); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lisaa(int luku) {
        super.lisaa(luku); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Solmu hae(int avain) {
        return super.hae(avain); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setJuuri(Solmu juuri) {
        super.setJuuri(juuri); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
