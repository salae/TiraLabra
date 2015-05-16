package vertailu;

/**
 * Treap on puun ja keon yhdistelmä, joka käyttää satunnaisuutta hyväkseen.
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
        this.juuri = null;
    }
    
    @Override
    public TreapSolmu hae(int avain) {
        return (TreapSolmu) super.hae(avain); 
    } 
    
    @Override
    public void lisaa(int avain) {
        TreapSolmu uusi = new TreapSolmu(avain);
        this.lisaaSolmu(uusi);
        this.korjaaKeko(uusi);
    } 
    
     /**
     * Korjataan puu lisäyksen jälkeen, niin että se toteuttaa keko-ominaisuuden.
     * 
     * Kyseessä on minimikeko.
     *
     * @param s korjattava solmu
     */
    private void korjaaKeko(TreapSolmu s) {
        while(s.getVanhempi() != null && s.getPrioriteetti() < ((TreapSolmu) s.getVanhempi()).getPrioriteetti()) {
            if (s == s.getVanhempi().getOikeaLapsi()) {
                kiertoVasemmalle(s.getVanhempi());
            } else {
                kiertoOikealle(s.getVanhempi());
            }
        } 
        if (s.getVanhempi() == null) {
            this.setJuuri(s);
        }
    } 
       
    @Override
    public void poista(int avain) {
        TreapSolmu pois = this.hae(avain);
        if(pois != null){
            valutaLehdeksi(pois);
            if (pois == pois.getVanhempi().getOikeaLapsi()) {
               pois.getVanhempi().setOikeaLapsi(null);
            }else {
               pois.getVanhempi().setVasenLapsi(null);
            }           
        }        
    }
   
    /**
     * Valuttaa poistettavan solmun alas päin puun lehdeksi.
     * 
     * @param pois alas valutettava solmu
     */
    private void valutaLehdeksi(TreapSolmu pois) {
        while(pois.getVasenLapsi() != null || pois.getOikeaLapsi() != null){
            if(pois.getVasenLapsi() == null){
                this.kiertoVasemmalle(pois);
            }else if(pois.getOikeaLapsi() == null){
                this.kiertoOikealle(pois);
            }else if(((TreapSolmu)pois.getVasenLapsi()).getPrioriteetti() < ((TreapSolmu)pois.getOikeaLapsi()).getPrioriteetti()){
                this.kiertoOikealle(pois);
            }else {
                this.kiertoVasemmalle(pois);
            }
            if(pois == this.getJuuri()){
                this.setJuuri(pois.getVanhempi());
            }
        }
    }
    
    /**
     * Kierretään solmua vasemmalle.
     * 
     * @param x kierrettävä solmu
     */
    private void kiertoVasemmalle(Solmu x) {
        Solmu y = x.getOikeaLapsi();
        x.setOikeaLapsi(y.getVasenLapsi());
        if(y.getVasenLapsi() != null) {
            y.getVasenLapsi().setVanhempi(x);
        }
        this.vaihdaAlipuuta(x, y);
        y.setVasenLapsi(x);
        x.setVanhempi(y);
    }
    
    /**
     * Kierretään solmua oikealle.
     * 
     * @param x kierrettävä solmu
     */
    private void kiertoOikealle(Solmu x) {
        Solmu y = x.getVasenLapsi();
        x.setVasenLapsi(y.getOikeaLapsi());
        if(y.getOikeaLapsi() != null) {
            y.getOikeaLapsi().setVanhempi(x);
        }
        this.vaihdaAlipuuta(x, y);
        y.setOikeaLapsi(x);
        x.setVanhempi(y);
    }

    /**
     * Asettaa lapsi-solmun oikelle puolelle vanhempaan nähden. 
     * Jos vanhempi on null, tehdään lapsesta juuri.
     * 
     * @param lapsi
     * @param vanhempi 
     */
    private void asetaVanhempiLapsiSuhde(Solmu x, Solmu y){
        if (x.getVanhempi() == null) {
            this.setJuuri(y);
        } else if (x == x.getVanhempi().getVasenLapsi()) {
            x.getVanhempi().setVasenLapsi(y);
        } else {
            x.getVanhempi().setOikeaLapsi(y);
        }
    }
  
    
}
