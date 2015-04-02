package vertailu;

/**
 * Binäärihakupuu
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

    public Solmu getJuuri() {
        return juuri;
    }

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
    public void lisaa(int avain) {
        
        Solmu uusi = new Solmu (avain);
        Solmu p = null;  //vanhempi
        if(this.juuri == null){
            this.juuri = uusi;
        } else {
            Solmu x = this.juuri;  //etsintäkohta          
            while(x != null){
                p = x;
                if(avain < x.getAvain()){
                    x = x.getVasenLapsi();
                } else {
                    x = x.getOikeaLapsi();
                }
            }uusi.setVanhempi(p);
            if(avain < p.getAvain()){
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
              Solmu lapsi = null;
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
              //tarvitaan min-metodia
              //toteutetaan myöhemmin
              
          }
        }
    }
    
}
