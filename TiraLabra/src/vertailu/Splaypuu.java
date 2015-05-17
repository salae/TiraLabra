package vertailu;

/**
 * Splaypuu on tasapainotettu binäärihakupuu, jonka erityisominaisuus on 
 * mukautuminen. Avainkysely nostaa kysytyn solmun puun juureksi, jolloin
 * peräkkäiset samoihin avaimiin kohdistuvat operaatiot ovat nopeita.
 * 
 * @author Anu
 */
public class Splaypuu extends BinHakupuu implements Puu{    

    /**
     * Luo tyhjän splaypuun.
     * 
     */
    public Splaypuu(){
        this.setJuuri(null);
    }
    
    /**
     * {@inheritDoc}
     * 
     * Jos haettu avain löytyy, solmulle suoritetaan splay-operaatio.
     */
    @Override
    public Solmu hae(int avain) {
        Solmu haettu = super.hae(avain);
        if(haettu != null) {
            this.splay(haettu);
        }
        return haettu;
    }
    
    /**
     * {@inheritDoc}
     * 
     * Lisätylle solmulle suoritetaan splay-operaatio.
     */
    @Override
    public void lisaa(int avain) {
        Solmu uusi = new Solmu(avain);
        this.lisaaSolmu(uusi);
        this.splay(uusi);
    }
    
    /**
     * {@inheritDoc}
     * 
     * Poistamisen jälkeen suoritetaan splay-operaatio
     * poistetun solmun vanhemmalle.
     */
    @Override
    public void poista(int avain){
        Solmu pois = super.hae(avain);
        if(pois != null){
           Solmu vanhempi = pois.getVanhempi();
           this.poistaSolmu(pois); 
           if(vanhempi != null){
              this.splay(vanhempi); 
           }           
        }        
    }   

    /**
     * Splay-operaatio, joka siirtää solmun puun juureksi
     * 
     * @param x siirrettävä solmu
     */
    private void splay(Solmu x) {
        while(x.getVanhempi() != null) {
            if(x.getVanhempi().getVanhempi() == null && x == x.getVanhempi().getVasenLapsi()) { //zig
                this.kiertoOikealle(x.getVanhempi());
            }else if(x.getVanhempi().getVanhempi() == null && x == x.getVanhempi().getOikeaLapsi()){ //zig
                this.kiertoVasemmalle(x.getVanhempi());
            }else if(x == x.getVanhempi().getVasenLapsi() && x.getVanhempi() == x.getVanhempi().getVanhempi().getVasenLapsi()){//zig-zig
                this.kiertoOikealle(x.getVanhempi().getVanhempi());
                this.kiertoOikealle(x.getVanhempi());
            }else if(x == x.getVanhempi().getOikeaLapsi() && x.getVanhempi() == x.getVanhempi().getVanhempi().getOikeaLapsi()) {//zig-zig
                this.kiertoVasemmalle(x.getVanhempi().getVanhempi()); 
                this.kiertoVasemmalle(x.getVanhempi()); 
            }else if(x == x.getVanhempi().getVasenLapsi() && x.getVanhempi() == x.getVanhempi().getVanhempi().getOikeaLapsi()){//zig-zag
                this.kiertoOikealle(x.getVanhempi()); 
                this.kiertoVasemmalle(x.getVanhempi());                 
            }else{//zig-zag
                this.kiertoVasemmalle(x.getVanhempi());
                this.kiertoOikealle(x.getVanhempi());
            }               
        }
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
  
}
