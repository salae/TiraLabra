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
     * Luo tyhjän binäärihakupuun
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
        return juuri;
    }

    /**
     * Asettaa puulle juuren
     * 
     * @param juuri 
     */
    public void setJuuri(Solmu juuri) {
        this.juuri = juuri;
    }
    
    
    @Override
    public Solmu hae(int avain) {
        Solmu x = this.juuri;  //etsintäkohta
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
     * Lisää puuhun uuden solmun
     * 
     * @param uusi lisättävä solmu
     */
    public void lisaaSolmu(Solmu uusi) {        
        Solmu p = null;  //vanhempi
        if(this.juuri == null){
            this.juuri = uusi;
        } else {
            Solmu x = this.juuri;  //etsintäkohta          
            while(x != null){
                p = x;
                if(uusi.getAvain() < x.getAvain()){
                    x = x.getVasenLapsi();
                } else {
                    x = x.getOikeaLapsi();
                }
            }uusi.setVanhempi(p);
            if(uusi.getAvain() < p.getAvain()){
                p.setVasenLapsi(uusi);
            } else {
                p.setOikeaLapsi(uusi);
            }             
        }
    }

    @Override
    public void poista(int avain) {
        Solmu pois = this.hae(avain);
        if(pois != null){          
          Solmu p = null;  //poistettavan vanhempi
          Solmu lapsi = null;
          //poistettavalla ei lapsia
          if(pois.getOikeaLapsi()== null && pois.getVasenLapsi() == null){
              p = pois.getVanhempi();
              if(p == null){
                  this.setJuuri(null);
              } else if(pois == p.getVasenLapsi()){
                  p.setVasenLapsi(null);
              } else {
                  p.setOikeaLapsi(null);
              }
          //poistettavalla on yksi lapsi
          } else if(pois.getOikeaLapsi() == null || pois.getVasenLapsi() == null){              
              if(pois.getVasenLapsi() != null){
                lapsi = pois.getVasenLapsi();
              } else {
                lapsi = pois.getOikeaLapsi();
              }
              p = pois.getVanhempi();
              lapsi.setVanhempi(p);
              if(p == null){
                  this.setJuuri(lapsi);
              }
              if(pois == p.getVasenLapsi()){
                  p.setVasenLapsi(lapsi);
              } else {
                  p.setOikeaLapsi(lapsi);
              } 
          //poistettavalla on kaksi lasta
          } else {
              Solmu seur = haeMin(pois.getOikeaLapsi());
              pois.setAvain(seur.getAvain());
              lapsi = seur.getOikeaLapsi();
              p = seur.getVanhempi();
              if(p.getVasenLapsi() == seur){
                  p.setVasenLapsi(lapsi);
              }else {
                  p.setOikeaLapsi(lapsi);
              }
              if(lapsi != null){
                  lapsi.setVanhempi(p);
              }
          }
        }
    }
    
    /**
     * Palauttaa solmun, jolla on arvoltaan pienin avain
     * 
     * Pienimmän arvon etsintä koskee alipuuta, jonka juuri annetaan parametrinä.
     * Pienipiä arvoja voi olla useita, joista yksi palautetaan. Jos puu on
     * tyhjä, palautetaan null.
     * 
     * @param s sen puun juuri, josta pienintä arvoa haetaan
     * @return pienimmän avaimen omaava solmu
     */
    public Solmu haeMin(Solmu s){
        while(s.getVasenLapsi() != null){
            s = s.getVasenLapsi();
        }        
        return s;
    }
    
    /**
     * Tulostaa annetusta solmusta alkavan alipuun
     * 
     * Jos halutaan tulostaa koko puu, annetaan parametrina puun juuri
     * 
     * @param s juuri, josta alkava alipuu tulostetaan
     */
    public void tulosta(Solmu s) {
        if (s != null) {
           tulosta(s.getVasenLapsi());
           System.out.println(s.toString());
           tulosta(s.getOikeaLapsi());
        }
    }
}
