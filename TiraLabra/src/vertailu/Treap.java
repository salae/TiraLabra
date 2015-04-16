package vertailu;

/**
 * Treap. Puun ja keon yhdistelmä, joka käyttää satunnaisuutta hyväkseen.
 * 
 * @author Anu
 */
public class Treap extends BinHakupuu implements Puu{
    private TreapSolmu juuri;

    /**
     * Luo tyhjän Treap-tietorakenteen.
     * 
     */
    public Treap() {
        this.setJuuri(null);
    }
    
    @Override
    public TreapSolmu hae(int avain) {
        return (TreapSolmu) super.hae(avain); 
    } 
    
    @Override
    public void lisaa(int avain) {
        TreapSolmu uusi = new TreapSolmu(avain);
        TreapSolmu vJuuri = (TreapSolmu) this.getJuuri();
        this.setJuuri(this.lisaaSolmu(uusi, vJuuri));        
    } 
    /**
     * Lisää solmun treapiin.
     * 
     * @param uusi  uusi solmu
     * @param vJuuri vanha (tämänhetkinen) juuri
     * @return uusi juuri
     */
    public TreapSolmu lisaaSolmu(TreapSolmu uusi, TreapSolmu vJuuri){
        if(vJuuri == null){
            return uusi;
        }else if(uusi.getAvain() < vJuuri.getAvain()){
            
        }else {
            
        }
        return vJuuri;
    }
    
    @Override
    public void poista(int avain) {
        
    }



  
    
}
