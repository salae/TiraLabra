package vertailu;

/**
 * Binäärihakupuu.
 * 
 * Puu, jossa jokaisella solmulla on korkeintaan kaksi lasta, ja solmun
 * vasemmassa alipuussa on ainoastaan sitä pienempiä tai yhtä suuria avaimia
 * ja oikeassa alipuussa sitä isompia tai yhtä suuria avaimia.
 * 
 * @author Anu
 */
public class BinHakupuu implements Puu{
    
    private Solmu juuri;

    /**
     * Luo tyhjän binäärihakupuun.
     */
    public BinHakupuu() {
        this.juuri = null;
    }
    
    /**
     * Palauttaa puun juuren
     * 
     * @return puun juuri
     */
    public Solmu getJuuri() {
        return this.juuri;
    }

    /**
     * Asettaa puulle juuren.
     * 
     * @param juuri 
     */
    public void setJuuri(Solmu juuri) {
        this.juuri = juuri;
    }
    
    @Override
    public Solmu hae(int avain) {
        Solmu x = this.juuri;
        while(x != null && x.getAvain() != avain){
            if(avain < x.getAvain()) {
                x = x.getVasenLapsi();
            } else {
                x = x.getOikeaLapsi();
            }
        }
        return x;
    }
    
    @Override
    public void lisaa(int luku){
        Solmu uusi = new Solmu(luku);
        lisaaSolmu(uusi);
    }
    
    /**
     * Lisää puuhun uuden solmun.
     * 
     * @param uusi lisättävä solmu
     */
    protected void lisaaSolmu(Solmu uusi) {        
        Solmu vanhempi = null; 
        Solmu x = this.juuri;           
        while(x != null){
            vanhempi = x;
            x = (uusi.getAvain() < x.getAvain()) ? x.getVasenLapsi() :  x.getOikeaLapsi();            
        }
        uusi.setVanhempi(vanhempi);
        asetaVanhempiLapsiSuhde(uusi, vanhempi);
  
    }

    /**
     * Asettaa lapsi-solmun oikelle puolelle vanhempaan nähden. 
     * Jos vanhempi on null, tehdään lapsesta juuri.
     * 
     * @param lapsi
     * @param vanhempi 
     */
    private void asetaVanhempiLapsiSuhde(Solmu lapsi, Solmu vanhempi){
        if(vanhempi == null){
            this.setJuuri(lapsi);
        }else if(lapsi.getAvain() < vanhempi.getAvain()){
            vanhempi.setVasenLapsi(lapsi);
        } else {
            vanhempi.setOikeaLapsi(lapsi);
        }  
    }
    
    @Override
    public void poista(int avain) {
        Solmu pois = this.hae(avain);
        if(pois != null){
            this.poistaSolmu(pois);
        }
    }
    
    /**
     * Poistaa puusta solmun
     * 
     * @param pois poistettava solmu 
     */
    protected void poistaSolmu(Solmu pois){
        if(pois.getVasenLapsi() == null){
            this.vaihdaAlipuuta(pois, pois.getOikeaLapsi());
        }else if(pois.getOikeaLapsi() == null){
            this.vaihdaAlipuuta(pois, pois.getVasenLapsi());
        }else {
            Solmu seur = this.haeMin(pois.getOikeaLapsi());
            if(seur.getVanhempi() != pois){
                this.vaihdaAlipuuta(seur, seur.getOikeaLapsi());
                seur.setOikeaLapsi(pois.getOikeaLapsi());
                seur.getOikeaLapsi().setVanhempi(seur);
            }
            this.vaihdaAlipuuta(pois, seur);
            seur.setVasenLapsi(pois.getVasenLapsi());
            seur.getVasenLapsi().setVanhempi(seur);
        }
    }
    
    /**
     * Vaihtaa yhden alipuun tilalle toisen.
     * 
     * @param eka vaihdettavan alipuun juuri
     * @param toka korvaavan alipuun juuri
     */
    protected void vaihdaAlipuuta(Solmu eka, Solmu toka){
        if(eka.getVanhempi() == null){
            this.setJuuri(toka);
        }else if(eka == eka.getVanhempi().getVasenLapsi()){
            eka.getVanhempi().setVasenLapsi(toka);
        }else {
            eka.getVanhempi().setOikeaLapsi(toka);
        }
        if(toka != null){
            toka.setVanhempi(eka.getVanhempi());
        }
    }   

    @Override    
    public Solmu haeMin(Solmu s){
        while(s.getVasenLapsi() != null){
            s = s.getVasenLapsi();
        }        
        return s;
    }    

    @Override
    public Solmu haeMax(Solmu s){
        while(s.getOikeaLapsi() != null){
            s = s.getOikeaLapsi();
        }        
        return s;
    }
    
    @Override
    public void tyhjennaPuu(Solmu s) {
        if (s != null) {
           tyhjennaPuu(s.getVasenLapsi());
           poistaSolmu(s);
           tyhjennaPuu(s.getOikeaLapsi());
        }
    }
    
    @Override
    public void tulostaPuu(Solmu s) {
        if (s != null) {
           tulostaPuu(s.getVasenLapsi());
           System.out.println(s.toString());
           tulostaPuu(s.getOikeaLapsi());
        }
    }
}
